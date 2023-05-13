import java.util.Random;

public class Student extends Degree { 
    // attributes
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id;
    private int startYear = 2023;
    private int graduationYear;
    private int degreeCount = 3;
    private Degree [] degrees = new Degree [] {new Degree(), new Degree(), new Degree()};
    //Degree degree = new Degree();
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    

    //constructors
    public Student() {
        id = getRandomId(); 
    }

    public Student(String lname, String fname) {
        // set given first and last name if not null
        if (lname != null && fname != null) { 
            id = getRandomId(); 
            firstName = fname;
            lastName = lname;
        }
    }

    // methods
    // get first name
    public String getFirstName() {
        return firstName;
    }

    // set first name
    public void setFirstName(String firstName) {

        if (firstName != null){
            this.firstName = firstName;
        }
    }

    //get last name
    public String getLastName () {
        return lastName;
    }

    //set last name
    public void setLastName (String lastName) {
        
        if (lastName != null){
            this.lastName = lastName;
        }
    }

    // get student id
    public int getId () {
        return id;
    }

    // set student id
    public void setId (final int id) {
        if (id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID){
            this.id = id;
        }
    }

    
    // get start year
    public int getstartYear () {
        return startYear;
    }

    // set start year
    public void setstartYear (final int startYear) {
        if (startYear > 2000 && startYear <= 2023) {
            this.startYear = startYear;
        }
    }

    // get graduation year
    public int getGraduationYear () {
        return graduationYear;
    }

    // set graduation year
    public String setGraduationYear (final int graduationYear) {
        if (canGraduate() == true){
            if (graduationYear <= 2023 && graduationYear >= startYear){
                this.graduationYear = graduationYear;
                return "Ok";
            }
            else {
                return "Check graduation year";
            }
        }
        else {
            return "Check amount of required credits";
        }
    }

    // check can graduate
    private boolean canGraduate () {

        if (degrees[0].getCredits() >= ConstantValues.BACHELOR_CREDITS && degrees[1].getCredits() >= ConstantValues.MASTER_CREDITS){
            if (degrees[0].getTitleOfThesis() != ConstantValues.NO_TITLE && degrees[1].getTitleOfThesis() != ConstantValues.NO_TITLE) {
                return true;
            }
        }
        return false;
    }

    // has graduated
    public boolean hasGraduated () {
        if (canGraduate() == true && (graduationYear <= 2023 && graduationYear >= startYear)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setDegreeTitle (final int i, String dName) {

        if (dName != null && i >= 0 && i < degreeCount ) {
            degrees[i].setDegreeTitle(dName);
        }
    }

    public boolean addCourse (final int i, StudentCourse course) {
        if (course != null && i >= 0 && i < degreeCount) {
            return degrees[i].addStudentCourse(course);
        }

        return false;
    }

    public int addCourses (final int i, StudentCourse [] courses) {
        int added = 0;
        if (courses != null && i >= 0 && i < degreeCount) {
            for (int s=0; s<courses.length; s++) {  
                if (courses[s] != null && degrees[i].getCount() < MAX_COURSES) {
                    addCourse(i, courses[s]);
                    added = added + 1;
                } 

            }
        }
        return added;
    }

    public void printCourses () {
        for (int i=0; i<degreeCount; i++) {
            if (degrees[i] != null) {
                degrees[i].printCourses();
                System.out.println("\n");
            }   
        }
    }

    public void printDegrees () {
        for (int i=0; i<degreeCount; i++) {
            if (degrees[i] != null) {
                System.out.println(degrees[i].toString());
                System.out.println("\n");
            }
        }
    }

    public void setTitleOfThesis (final int i, String title) {
        degrees[i].setTitleOfThesis(title);
    }

    public String getBirthDate () {
        return birthDate;
    }

    public String setBirthDate (String personId) {
        PersonID pID = new PersonID();

        if (personId == null) {
            return "No change";
        }
        pID.setPersonID(personId);

        if (pID.getBirthDate() == ConstantValues.NO_BIRTHDATE) {
            return "No change";
        }

        this.birthDate = pID.getBirthDate();
        return pID.getBirthDate();
    }

    // get study years
    public int getStudyYears () {
        if (hasGraduated() == true){
            return graduationYear - startYear;
        }
        else {
            return 2023 - startYear;
        }
    }

    // get random id
    private int getRandomId () {
        Random rand = new Random();
        id = rand.nextInt((ConstantValues.MAX_ID - ConstantValues.MIN_ID) + 1) + ConstantValues.MIN_ID;
        return id;
    }

    // to string
    public String toString () {
        String status = "";
        String missingbac = "";
        String missingmas = "";

        double totcredits = degrees[0].getTotalCredits() + degrees[1].getTotalCredits();

        if (hasGraduated() == true) {
            status = "The student has graduated in " + Integer.toString(getGraduationYear());
            if (degrees[0].getTotalCredits() >= ConstantValues.BACHELOR_CREDITS) {
                missingbac = "\n   Total bachelor credits completed (" + degrees[0].getTotalCredits() + "/180.0)";
            }
            if (degrees[1].getTotalCredits() >= ConstantValues.MASTER_CREDITS) {
                missingmas = "\n   Total master's credits completed (" + degrees[1].getTotalCredits() + "/120.0)";
            }
            
        }
        else if (hasGraduated() == false) {
            status = "The student has not graduated, yet.";
            if (degrees[0].getTotalCredits() >= ConstantValues.BACHELOR_CREDITS) {
                missingbac = "\n   Total bachelor credits completed (" + degrees[0].getTotalCredits() + "/180.0)";
            }
            if (degrees[0].getTotalCredits() < ConstantValues.BACHELOR_CREDITS) {
                double miscredits = ConstantValues.BACHELOR_CREDITS-degrees[0].getTotalCredits();
                missingbac = "\n   Missing bachelor's credits " + miscredits + " (" + degrees[0].getTotalCredits() + "/180.0)";
            }
            if (degrees[1].getTotalCredits() >= ConstantValues.MASTER_CREDITS) {
                missingmas = "\n   Total master's credits completed (" + degrees[1].getTotalCredits() + "/120.0)";
            }

            if (degrees[1].getTotalCredits() < ConstantValues.MASTER_CREDITS) {
                double miscreditsmas = ConstantValues.MASTER_CREDITS-degrees[1].getTotalCredits();
                missingmas = "\n   Missing master's credits " + miscreditsmas  + " (" + degrees[1].getTotalCredits() + "/120.0)";
            }
        }

        return "Student id: " + id 
        + "\nFirstName: " + firstName 
        + ", LastName: " + lastName 
        + "\nDate of birth: " + getBirthDate()
        + "\nStatus: "  + status
        + "\nStartYear: " + startYear + " (studies have lasted for " + getStudyYears() + " years)" 
        + "\nTotal credits: " + totcredits
        + "\nBachelor Credits: " + degrees[0].getTotalCredits()
        + missingbac
        + "\n   Title of BSc Thesis: " + degrees[0].getTitleOfThesis()
        + "\nMaster credits: " + degrees[1].getTotalCredits()
        + missingmas
        + "\n   Title of MSc Thesis: " + degrees[1].getTitleOfThesis();
    }
}