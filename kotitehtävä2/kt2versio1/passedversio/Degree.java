public class Degree extends StudentCourse {

    // attributes
    static final int MAX_COURSES = 50;
    int count = 0;
    String degreeTitle = ConstantValues.NO_TITLE;
    String titleOfThesis = ConstantValues.NO_TITLE;
    StudentCourse [] myCourses = new StudentCourse[MAX_COURSES];
    // extra attribute for calculating total credits for the prints
    double totalCredits = 0.0;

    // methods
    public StudentCourse [] getCourses () {
        return myCourses;
    }

    public int getCount() {
        return count;
    }
    
    // add several courses to mycourses
    public void addStudentCourses (StudentCourse [] courses) {
        if (courses != null ) {
            for (int i=0; i<courses.length; i++) {
                addStudentCourse(courses[i]);
            }
        }
    }

    // add course to mycourses if course is not null and there is room for course.
    public boolean addStudentCourse (StudentCourse course) {
        if (course != null) {
            if (count < MAX_COURSES) {
                myCourses[count] = course;
                count = count +1;
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
        for (int i = 0; i<myCourses.length; i++){
            if (myCourses[i] != null) {
                Course cour = myCourses[i].getCourse();
                
                if (cour.getCourseBase() == base && myCourses[i].isPassed() == true) {
                    total += cour.getCredits();
                }
            }
        }

        return total;
    }

    // get credits by type
    public double getCreditsByType (final int courseType){
        double total = 0;
        
        for (int i = 0; i<myCourses.length; i++){
            if (myCourses[i] != null) {
                Course cour = myCourses[i].getCourse();
                
                if (cour.getCourseType() == courseType && myCourses[i].isPassed() == true) {
                    total += cour.getCredits();
                }
            }
        }

        return total;
    }

    // pitäisi palauttaa kurssien määrä tehtävänannon mukaan, mutta tarkistimen mukaan opintopisteiden määrä
    public double getCredits () {
        double total = 0.0;
        for (int i = 0; i<myCourses.length; i++){
            if (myCourses[i] != null) {
                if (myCourses[i].isPassed() == true) {
                    Course cour = myCourses[i].getCourse();
                    total += cour.getCredits();
                }
            }
        }
        return total;
    }


    // get credits of the all passed courses
    public double getTotalCredits () {
        double total = 0.0;
        for (int i = 0; i<myCourses.length; i++){
            if (myCourses[i] != null) {
                if (myCourses[i].isPassed() == true) {
                    Course cour = myCourses[i].getCourse();
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
        
         
        for (int i = 0; i<myCourses.length; i++){
            
            if (myCourses[i] != null) {
                System.out.println(myCourses[i].toString());
            }
            
        }
    }

    // to string
    public String toString() {
        String start = "";
        start = "Degree [Title: " + '"' + degreeTitle + '"' + " (courses: " + count + ")" + "Thesis title: " + '"' + titleOfThesis + '"';
        
        String courses = "";
        
        for (int i = 0; i<myCourses.length; i++){
            if (myCourses[i] != null) {
                courses += "\n";
                courses += myCourses[i].toString();
                
            }
            
        }
        
        courses += "]";
        return start + courses;
    }
}
