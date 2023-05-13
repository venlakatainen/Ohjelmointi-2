//package dev.m3s.programming2.homework2;
public class StudentCourse extends Course {
    // attributes
    Course course;
    int gradeNum;
    int yearCompleted;

    // constructors

    public StudentCourse () {

    }

    public StudentCourse (Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);

    }

    // methods
    // get course
    public Course getCourse() {
        return course;
    }

    // set course
    public void setCourse (Course course) {
        this.course = new Course(course);
    }

    // get grade
    public int getGradeNum() {
        return gradeNum;
    }

    // set grade
    protected void setGrade(int gradeNum) {
        if (checkGradeValidity(gradeNum) == true) {
            if (gradeNum == 65 || gradeNum == 97) {
                this.gradeNum = 'A';
                if (yearCompleted == 0){
                    yearCompleted = 2023;
                }
            }
            else if (gradeNum == 70 || gradeNum == 102) {
                this.gradeNum = 'F';
                if (yearCompleted == 0){
                    yearCompleted = 2023;
                }
            }
            else {
                this.gradeNum = gradeNum;
                if (yearCompleted == 0){
                    yearCompleted = 2023;
                }
            }
        }
    }

    // check if the grade is validy
    private boolean checkGradeValidity (final int gradeNum) {
        if (((gradeNum >= ConstantValues.MIN_GRADE) && (gradeNum <= ConstantValues.MAX_GRADE)) || gradeNum == ConstantValues.GRADE_FAILED || gradeNum == 102 || gradeNum == 97 || gradeNum == ConstantValues.GRADE_ACCEPTED) {
            return true;
        }
        else {
            return false;
        }
        
    }

    // check if the course is passed
    public boolean isPassed () {
        if (gradeNum == ConstantValues.MIN_GRADE || (char) gradeNum == ConstantValues.GRADE_FAILED) {
            return false;
        }
        return true;
    }

    // get the year when the course is completed
    public int getYear() {
        return yearCompleted;
    }

    // set the year when the course is completed
    public void setYear(final int year) {
        if (year > 2000 && year <= 2023){
            yearCompleted = year;
        }
    }

    // to string
    @Override
    public String toString() {

        if (gradeNum == 0) {
            return "[" + course.getCourseCode() 
            + " (" + course.getCredits() + " cr) " 
            + course.getName() + ". " + course.getCourseTypeString()
            + ", " + "period: " + course.getPeriod() + ".] Year: "
            + yearCompleted + ", Grade: Not graded.]" ;
        }

        else if (gradeNum <= ConstantValues.MAX_GRADE && gradeNum >= ConstantValues.MIN_GRADE) {
            return "[" + course.getCourseCode() 
            + " (" + course.getCredits() + " cr) " 
            + course.getName() + ". " + course.getCourseTypeString()
            + ", " + "period: " + course.getPeriod() + ".] Year: "
            + yearCompleted + ", Grade: " + gradeNum + ".]" ;
        }

        else if (gradeNum == ConstantValues.GRADE_ACCEPTED) {
            return "[" + course.getCourseCode() 
            + " (" + course.getCredits() + " cr) " 
            + course.getName() + ". " + course.getCourseTypeString()
            + ", " + "period: " + course.getPeriod() + ".] Year: "
            + yearCompleted + ", Grade: A" + ".]" ;
        }

        else if (gradeNum == ConstantValues.GRADE_FAILED) {
            return "[" + course.getCourseCode() 
            + " (" + course.getCredits() + " cr) " 
            + course.getName() + ". " + course.getCourseTypeString()
            + ", " + "period: " + course.getPeriod() + ".] Year: "
            + yearCompleted + ", Grade: F" + ".]" ;
        }
     
        else {
            return "[" + course.getCourseCode() 
            + " (" + course.getCredits() + " cr) " 
            + course.getName() + ". " + course.getCourseTypeString()
            + ", " + "period: " + course.getPeriod() + ".] Year: "
            + yearCompleted + ", Grade: " + gradeNum + ".]" ;
        }
    }
}