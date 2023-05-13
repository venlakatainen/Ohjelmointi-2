public class Main {

    public static void main (String [] args){

        //test1();
        test2();

    }
    /*
    private static void test1 () {

        Student op1 = new Student();

        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 1, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);
        

        StudentCourse studentCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studentCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studentCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studentCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studentCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studentCourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse studentCourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse studentCourse11 = new StudentCourse(course11, 'f', 2022);

        StudentCourse [] myStudies = new StudentCourse[] {studentCourse1, studentCourse2, studentCourse3, studentCourse4, studentCourse5, studentCourse6, studentCourse7, studentCourse8, studentCourse9, studentCourse10, studentCourse11};

        op1.setDegreeTitle("Bachelor of Science");

        op1.setTitleOfThesis("Bachelor thesis title");
        
        op1.addCourses(myStudies);

        //System.out.println(myStudies.toString());
        

        op1.setstartYear(2001);

        op1.setFirstName("Donald");

        op1.setLastName("Duck");

        System.out.println(op1.toString());

        op1.setGraduationYear(2020);

        op1.setBirthDate();

        op1.setTitleOfThesis("Christmas - The most wonderful time of the year");

        myStudies[8].setGrade(3);

        System.out.println("\n");

        System.out.println(op1.toString());

        System.out.println("\n");

        op1.printDegree();

        System.out.println("\n");

        op1.printCourses();

        System.out.println("\n");

        myStudies[10].setGrade('X');
        
        System.out.println(myStudies[10].toString());

        System.out.println("\n");

        myStudies[10].setGrade('a');

        System.out.println(myStudies[10].toString());

        System.out.println("\n");

        myStudies[0].setGrade(6);

        System.out.println(myStudies[0].toString());

        System.out.println("\n");

        myStudies[0].setGrade(5);

        System.out.println(myStudies[0].toString());
    }
    */

    public static void test2() {
        
        Student op1 = new Student();

        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 36.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 49.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 44.0, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 1, 3, 40.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 11.0, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 48.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 3, 47.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 0.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 0.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 0.0, false);
        

        StudentCourse studentCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studentCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studentCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studentCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studentCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studentCourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse studentCourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse studentCourse11 = new StudentCourse(course11, 'f', 2022);

        StudentCourse [] bachelorCourses = new StudentCourse[] {studentCourse1, studentCourse2, studentCourse3, studentCourse4, studentCourse5};
        StudentCourse [] masterCourses = new StudentCourse[] {studentCourse6, studentCourse7, studentCourse8, studentCourse9, studentCourse10, studentCourse11};

        op1.addCourses(0, bachelorCourses);
        op1.addCourses(1, masterCourses);

        op1.setDegreeTitle(0, "Bachelor of Science");
        op1.setDegreeTitle(1, "Master of Science");

        op1.setTitleOfThesis(0, "Bachelor thesis title");
        op1.setTitleOfThesis(1, "Master thesis title");
        op1.setTitleOfThesis(2, "No title");

        op1.setstartYear(2021);
        System.out.println(op1.setGraduationYear(2000));

        op1.setFirstName("Donald");
        op1.setLastName("Duck");

        System.out.println(op1.toString());
        System.out.println("\n");

        //op1.setBirthDate();

        System.out.println(op1.toString());
        System.out.println("\n");

        op1.setTitleOfThesis(0, "Christmas - The most wonderful time of the year");
        op1.setTitleOfThesis(1, "Dreaming of a white Christmas");

        op1.printDegrees();
        System.out.println("\n");

        masterCourses[3].setGrade(3);

        System.out.println(masterCourses[3].toString());
        System.out.println("\n");

        op1.printDegrees();
        System.out.println("\n");

        op1.printCourses();
        System.out.println("\n");

        masterCourses[5].setGrade('X');

        System.out.println(masterCourses[5].toString());
        System.out.println("\n");

        masterCourses[5].setGrade('a');

        System.out.println(masterCourses[5].toString());
        System.out.println("\n");

        bachelorCourses[0].setGrade(6);

        System.out.println(bachelorCourses[0].toString());
        System.out.println("\n");

        bachelorCourses[0].setGrade(5);

        System.out.println(bachelorCourses[0].toString());
        System.out.println("\n");


    }


}   