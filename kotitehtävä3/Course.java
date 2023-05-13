//package dev.m3s.programming2.homework3;
public class Course {

    // attributes
    String name = "No title";
    String courseCode = "Not available";
    Character courseBase = ' ';
    int courseType;
    int period;
    double credits;
    boolean numericGrade;

    // constructors
    public Course () {

    }

    public Course (String name, 
    final int code, Character courseBase, 
    final int type, final int period, final 
    double credits, boolean numericGrade) {
        
        setName(name);

        setCourseCode(code, courseBase);

        setCourseType(type);
        
        setPeriod(period);
        
        setCredits(credits);
        
        setNumericGrade(numericGrade);
    }

    public Course (Course course) {

        setName(course.getName());

        setCourseCode(Integer.parseInt(course.getCourseCode().substring(0,course.getCourseCode().length()-1)), course.getCourseBase());

        setCourseType(course.getCourseType());

        setPeriod(course.getPeriod());

        setCredits(course.getCredits());

        setNumericGrade(course.isNumericGrade());
    }
    
    // methods
    // get name
    public String getName () {
        return name;
    }

    // set name
    public void setName (String name) {

        if (name != "" && name != null) {
            this.name = name;
        }
    }

    // get course type
    public String getCourseTypeString () {
        if (courseType == ConstantValues.OPTIONAL) {
            return "Optional";
        }
        else {
            return "Mandatory";
        }
        
    }
    
    // get course type
    public int getCourseType() {
        return courseType;
    }

    // set course type
    public void setCourseType (final int type) {
        if (type == 0 || type == 1) {
            courseType = type;
        }
    }

    // get course code
    public String getCourseCode() {
        return courseCode;
    }

    // set course code
    public void setCourseCode (final int courseCode, Character courseBase) {
        if (courseCode < 1000000 && courseCode > 0 && (Character.toUpperCase(courseBase) == 'A' || Character.toUpperCase(courseBase) == 'P' || Character.toUpperCase(courseBase) == 'S')) {
            this.courseCode = Integer.toString(courseCode);
            this.courseCode += Character.toUpperCase(courseBase);
            this.courseBase = Character.toUpperCase(courseBase);
        }
    }

    // get course base
    public Character getCourseBase () {
        return courseBase;
    }

    // get period
    public int getPeriod() {
        return period;
    }

    // set period
    public void setPeriod (final int period) {
        if (period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    // get credits
    public double getCredits () {
        return credits;
    }

    // set credits
    private void setCredits (final double credits) {
        if (credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    // is numeric grade 
    public boolean isNumericGrade () {
        return numericGrade;
    }

    // set numeric grade
    public void setNumericGrade (boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    //to string
    public String toString () {

        return 
        "[" + courseCode + " ( " + String.format("%.2f",credits) + " cr), " 
        + '"' +  name + '"' + ". " + getCourseTypeString()
        + ", period: "  + period + ".]" ;
    }
}   
