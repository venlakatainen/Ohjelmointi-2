//package dev.m3s.programming2.homework3;
public class DesignatedCourse {

    // attributes
    Course course;
    boolean responsible;
    int year;

    // constructors
    public DesignatedCourse () {

    }

    public DesignatedCourse (Course course, boolean resp, int year){
        if (course != null) {
            setCourse(course);
        }    
        
        setResponsible(resp);
        setYear(year); 
        
    }

    // methods
    // get course
    public Course getCourse () {
        return course;
    }

    // set course
    public void setCourse (Course course) {
        this.course = course;
    }


    // is responsible
    public boolean isResponsible () {
        return responsible;
    }

    // set responsible
    public void setResponsible (boolean responsible) {
        this.responsible = responsible;
    }

    // get responsible
    public boolean getResponsible () {
        return responsible;
    }

    // get year
    public int getYear () {
        return year;
    }

    // set year
    public void setYear (int year) {
        if (year >= 2000 && year <= 2024) {
            this.year = year;
        }
    }

    // to string
    public String toString () {
        return "[course=" + course.toString() + ", year = " + getYear() + "]";
    }
}
