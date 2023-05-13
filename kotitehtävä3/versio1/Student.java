import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Student extends Person {
    
    //attributes
    int id;
    int startYear = 2023;
    int graduationYear;
    private Degree [] degreesinit = new Degree [] {new Degree(), new Degree(), new Degree()};
    List<Degree> degrees = new ArrayList<> (Arrays.asList(degreesinit));

    private static final DecimalFormat df = new DecimalFormat("0.00");

    // constructor
    public Student (String lname, String fname) {
       
        super(lname, fname);
        id = getRandomId(1, 100);

    }


    // methods
    // get id
    public int getId () {
        return id;
    }

    // set id
    public void setId (final int id) {
        if (id > 0 && id < 101) {
            this.id = id;
        }
    }

    // get start year
    public int getStartYear () {
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
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);

        if (array[0].getCredits() >= ConstantValues.BACHELOR_CREDITS && array[1].getCredits() >= ConstantValues.MASTER_CREDITS){
            if (array[0].getTitleOfThesis() != ConstantValues.NO_TITLE && array[1].getTitleOfThesis() != ConstantValues.NO_TITLE) {
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

    // set degree title
    public void setDegreeTitle (final int i, String dName) {
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);


        if (dName != null && i >= 0 && i < 3 ) {
            array[i].setDegreeTitle(dName);
            degrees = Arrays.asList(array);
        }
    }


    // add course
    public boolean addCourse (final int i, StudentCourse course) {
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);
        if (course != null && i >= 0 && i < 50) {
            if (array[i].addStudentCourse(course) == true){
                degrees = Arrays.asList(array);
                return true;
            }

        }
        return false;
    }


    // add courses
    public int addCourses (final int i, List<StudentCourse> courses) {
        int added = 0;
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);
        if (i >= 0 && i < 3) {
            for (int s=0; s<courses.size(); s++) {  
                StudentCourse course = courses.get(s);          
                if (course != null && array[i].getCount() < 50) {
                    addCourse(i, course);
                    added = added + 1;
                } 
            }
        }
        return added;
    }


    // print courses
    public void printCourses () {
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);

        for (int i=0; i<array[i].getCount(); i++) {
            if (array[i] != null) {
                array[i].printCourses();
                System.out.println("\n");
            }   
        }
    }


    // print degrees
    public void printDegrees () {
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);

        for (int i=0; i<3; i++) {
            if (array[i] != null) {
                System.out.println(array[i].toString());
                System.out.println("\n");
            }
        }
    }


    // set title of thesis
    public void setTitleOfThesis (final int i, String title) {
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);
        array[i].setTitleOfThesis(title);
        degrees = Arrays.asList(array);
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


    // get id string
    public String getIdString() {
        return "Student id: " + Integer.toString(id);
    }


   // to string
    public String toString () {
        Degree [] array = new Degree [degrees.size()];
        degrees.toArray(array);


        String status = "";
        String missingbac = "";
        String missingmas = "";
        
        List<Double> bachelor = array[0].countGPA();

        List<Double> master = array[1].countGPA();

        Double totalAverage = (bachelor.get(1) + master.get(1)) / (bachelor.get(0) + master.get(0));

        double totcredits = array[0].getTotalCredits() + array[1].getTotalCredits();
        
        String totalAveragestring = df.format(totalAverage);
        totalAveragestring = totalAveragestring.replace(',', '.');

        String bacAveragestring = df.format(bachelor.get(2));
        bacAveragestring = bacAveragestring.replace(',', '.');

        String masAveragestring = df.format(master.get(2));
        masAveragestring = masAveragestring.replace(',', '.');



        if (hasGraduated() == true) {
            status = "The student has graduated in " + Integer.toString(getGraduationYear());
            if (array[0].getTotalCredits() >= ConstantValues.BACHELOR_CREDITS) {
                missingbac = "\n   Total bachelor credits completed (" + array[0].getTotalCredits() + "/180.0)";
            }
            if (array[1].getTotalCredits() >= ConstantValues.MASTER_CREDITS) {
                missingmas = "\n   Total master's credits completed (" + array[1].getTotalCredits() + "/120.0)";
            }
            
        }
        else if (hasGraduated() == false) {
            status = "The student has not graduated, yet.";
            if (array[0].getTotalCredits() >= ConstantValues.BACHELOR_CREDITS) {
                missingbac = "\n   Total bachelor credits completed (" + array[0].getTotalCredits() + "/180.0)";
            }
            if (array[0].getTotalCredits() < ConstantValues.BACHELOR_CREDITS) {
                double miscredits = ConstantValues.BACHELOR_CREDITS-array[0].getTotalCredits();
                missingbac = "\n   Missing bachelor's credits " + miscredits + " (" + array[0].getTotalCredits() + "/180.0)";
            }
            if (array[1].getTotalCredits() >= ConstantValues.MASTER_CREDITS) {
                missingmas = "\n   Total master's credits completed (" + array[1].getTotalCredits() + "/120.0)";
            }

            if (array[1].getTotalCredits() < ConstantValues.MASTER_CREDITS) {
                double miscreditsmas = ConstantValues.MASTER_CREDITS-array[1].getTotalCredits();
                missingmas = "\n   Missing master's credits " + miscreditsmas  + " (" + array[1].getTotalCredits() + "/120.0)";
            }
        }

        return "Student id: " + id 
        + "\nFirstName: " + firstName 
        + ", LastName: " + lastName 
        + "\nDate of birth: " + getBirthDate()
        + "\nStatus: "  + status
        + "\nStartYear: " + startYear + " (studies have lasted for " + getStudyYears() + " years)" 
        + "\nTotal credits: " + totcredits + " (GPA = " + totalAveragestring + ")"
        + "\nBachelor Credits: " + array[0].getTotalCredits()
        + missingbac
        + "\n   All mandatory bachelor credits completed (" + array[0].getCreditsByType(1) + "/150.0)"
        + "\n   GPA of Bachelor studies: " + bacAveragestring
        + "\n   Title of BSc Thesis: " + '"' + array[0].getTitleOfThesis() + '"'
        + "\nMaster credits: " + array[1].getTotalCredits()
        + missingmas
        + "\n   All mandatory master credits completed (" + array[1].getCreditsByType(1) + "/50.0)"
        + "\n   GPA of Master studies: " + masAveragestring
        + "\n   Title of MSc Thesis: " + '"' + array[1].getTitleOfThesis() + '"';
    }



}