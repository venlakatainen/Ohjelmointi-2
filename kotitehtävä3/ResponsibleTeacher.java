//package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.text.DecimalFormat;

public class ResponsibleTeacher extends Employee implements Teacher,Payment {

    // attribute
    private List<DesignatedCourse> courses = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("0.00");

    // constructor
    public ResponsibleTeacher (String lname, String fname) {
        super(lname, fname);
    }

    // methods
    // get employee id as a string
    public String getEmployeeIdString () {

        return "OY_TEACHER_";
    }

    // get courses
    public String getCourses () {

        String coursesString = "Teacher for courses :  ";
        
        DesignatedCourse [] array = new DesignatedCourse [courses.size()];
        courses.toArray(array);

        if (array.length == 0) {
            return "";
        } 
        
        for (int i = 0; i<array.length; i++){
            if (array[i] != null) {
                
                if (array[i].isResponsible() == true) {
                    coursesString += "Responsible teacher: ";
                }
                
                else if (array[i].isResponsible() == false) {
                    coursesString += "Teacher: ";
                }

                coursesString += array[i].toString();
                coursesString += "\n";
            }
        } 
        return coursesString;

    }

    // set courses
    public void setCourses (List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses; 
        }
    }

    // to string
    public String toString () {

        double salaryFormat = calculatePayment();
        String salaryString = df.format(salaryFormat);
        salaryString = salaryString.replace(',', '.');
        String id = "";
        String wholeid = getIdString();

        if (wholeid.length() > 4) {
            id = wholeid.substring(wholeid.length() - 4);
        } else {
            id = wholeid;
        }

        return " Teacher id: " + getIdString()
        + "\n First name: " + getFirstName() + ", Last name: " + getLastName()
        + "\n Birthdate: " + getBirthDate()
        + "\n Salary: " + salaryString
        + "\n  " + getCourses();

    }
}   
