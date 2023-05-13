import java.util.Random;

public class Student extends Degree { 
    // attributes
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id;
    private int startYear = 2023;
    private int graduationYear;
    private Degree degree = new Degree();
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
        if (degree.getCredits() >= ConstantValues.BACHELOR_CREDITS){
            if (degree.getTitleOfThesis() != ConstantValues.NO_TITLE) {
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

    public void setDegreeTitle (String dName) {
        
        if (dName != null) {
            degree.setDegreeTitle(dName);
        }
        
    }

    public boolean addCourse (StudentCourse course) {
        if (course != null && degree.getCount() < 50) {
            degree.addStudentCourse(course);
            return true;
        }

        return false;
    }

    public int addCourses (StudentCourse [] courses) {
        int added = 0;
        if (courses != null) {
            for (int i=0; i<courses.length; i++) {
                if (courses[i] != null && degree.getCount() < 50){
                    addCourse(courses[i]);
                    added = added +1;
                }
            }
        }

        return added;
    }

    public void printCourses () {
        degree.printCourses();
    }

    public void printDegree () {
        System.out.println(degree.toString());
    }

    public void setTitleOfThesis (String title) {
        degree.setTitleOfThesis(title);
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


    public String toString () {
        String status = "";

        if (hasGraduated() == true) {
            status = "The student has graduated in " + Integer.toString(getGraduationYear());
        }
        else if (hasGraduated() == false) {
            status = "The student has not graduated, yet.";
        }

        return "Student id: " + id 
        + "\nFirstName: " + firstName 
        + ", LastName: " + lastName 
        + "\nDate of birth: " + getBirthDate()
        + "\nStatus: "  + status
        + "\nStartYear: " + startYear + " (studies have lasted for " + getStudyYears() + " years)" 
        + "\nCredits: " + degree.getTotalCredits() 
        + "\nTotal credits completed (" + degree.getTotalCredits() + "/180.0)"
        + "\nTitle of Thesis: " + degree.getTitleOfThesis();
        
    }

}
