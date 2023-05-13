//package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;

public class Degree {

    // attributes
    static final int MAX_COURSES = 50;
    int count = 0;
    String degreeTitle = ConstantValues.NO_TITLE;
    String titleOfThesis = ConstantValues.NO_TITLE;
    //StudentCourse [] myCoursesInit = new StudentCourse();
    List<StudentCourse> myCourses = new ArrayList<> ();
    // extra attribute for calculating total credits for the prints
    double totalCredits = 0.0;

    // methods
    public List<StudentCourse> getCourses () {
        return myCourses;
    }

    public int getCount () {
        return myCourses.size();
    }
    
    // add several courses to mycourses
    public void addStudentCourses (List<StudentCourse> courses) {

        if (courses != null ) {
            StudentCourse [] array = new StudentCourse [courses.size()];
            courses.toArray(array);

            for (int i=0; i<array.length; i++) {
                //StudentCourse c = new StudentCourse(array[i]);
                addStudentCourse(array[i]);
            }
        }
    }

    // add course to mycourses if course is not null and there is room for course.
    public boolean addStudentCourse (StudentCourse course) {
        if (course != null) {
            if (myCourses.size() < MAX_COURSES) {
                myCourses.add(course);
                //count = count +1;
                return true;
            } 
        }
        return false;
    }

    // get degree title
    public String getDegreeTitle () {
        return degreeTitle;
    }

    // set degree title
    public void setDegreeTitle (String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }

    // get title of thesis
    public String getTitleOfThesis () {
        return titleOfThesis;
    }

    // set title of thesis
    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    // get credits by base
    public double getCreditsByBase(Character base) {
        double total = 0;
        for (int i = 0; i<myCourses.size(); i++){
            StudentCourse course = myCourses.get(i);
            if (course != null) {
                Course cour = course.getCourse();
            
                if (cour.getCourseBase() == base && course.isPassed() == true) {
                    total += cour.getCredits();
                }
            }
            
        }

        return total;
    }

    // get credits by type
    public double getCreditsByType (final int courseType){
        double total = 0;
        for (int i = 0; i<myCourses.size(); i++){
            StudentCourse course = myCourses.get(i);
            if (course != null) {
                Course cour = course.getCourse();
                
                if (cour.getCourseType() == courseType && course.isPassed() == true) {
                    total += cour.getCredits();
                }
            }
        }

        return total;
    }

    public double getCredits () {
        double total = 0.0;
        for (int i = 0; i<myCourses.size(); i++){
            StudentCourse course = myCourses.get(i);
            if (course != null) {
                if (course.isPassed() == true) {
                    Course cour = course.getCourse();
                    total += cour.getCredits();
                }
            }
        }
        return total;
    }


    // get credits of the all passed courses
    public double getTotalCredits () {
        double total = 0.0;
        for (int i = 0; i<myCourses.size(); i++){
            StudentCourse course = myCourses.get(i);
            if (course != null) {
                if (course.isPassed() == true) {
                    Course cour = course.getCourse();
                    total += cour.getCredits();
                }
            }
        }
        return total;
    }

    // check if given course is completed
    private boolean isCourseCompleted (StudentCourse c) {
        if (c.isPassed() == true){
            return true;
        }
        return false;
    }

    // print courses
    public void printCourses() {
        for (int i = 0; i<myCourses.size(); i++){
            StudentCourse course = myCourses.get(i);
            if (course != null) {
                System.out.println(course.toString());
            }
            
        }
    }


    public List<Double> getGPA (int type) {
        Double sum = 0.0;
        Double count = 0.0;
        Double average = 0.0;

        if (type == 2) {
            for (int i = 0; i<myCourses.size(); i++){
                StudentCourse course = myCourses.get(i);
                if (course != null) {
                    Course cour = course.getCourse();
                    if (cour.isNumericGrade() == true) {
                        sum = sum + 1;
                        count = count + course.getGradeNum();
                    }

                }
            }
        }
        
        else if (type == 0 || type == 1) {
            for (int i = 0; i<myCourses.size(); i++){
                StudentCourse course = myCourses.get(i);
                if (course != null) {
                    Course cour = course.getCourse();
                    if (cour.getCourseType() == type) {
                        if (cour.isNumericGrade() == true) {
                            sum = sum + 1;
                            count = count + course.getGradeNum();
                        }
                        
                    }
                }
            }
        }
        average = count / sum;

        List<Double> list = new ArrayList<Double>();
        list.add(count);
        list.add(sum);
        list.add(average); 
        
        return list;
    }
    
    public List<Double> countGPA () {
        
        Double sum = 0.0;
        Double count = 0.0;
        
        for (int i = 0; i<myCourses.size(); i++){
            StudentCourse course = myCourses.get(i);
            if (course != null) {
                Course cour = course.getCourse();
                if (cour.isNumericGrade() == true) {
                    sum = sum + 1;
                    count = count + course.getGradeNum();
                    
                }
            }
        }

        double average = count / sum;
        List<Double> list = new ArrayList<Double>();
        list.add(sum);
        list.add(count);
        list.add(average); 
        
        return list;
    }
    
    // to string
    @Override
    public String toString() {
        String start = "";
        start = "Degree [Title: " + '"' + degreeTitle + '"' + " (courses: " + getCount() + ")" + " Thesis title: " + '"' + titleOfThesis + '"';
        
        String courses = "";
        
        for (int i = 0; i<myCourses.size(); i++){
            StudentCourse course = myCourses.get(i);
            if (course != null) {
                courses += "\n";
                courses += course.toString();
            }
        }
        courses += "]";
        return start + courses;
    }
}
