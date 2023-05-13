import java.util.ArrayList;
import java.util.*;

public class Main {

    
    public static void main (String [] args){

        test2();


    }
    /* 
    public static void test1 () {

        Employee emp1 = new Employee("Mouse", "Mickey");
        emp1.setBirthDate("230498-045T");
        emp1.setSalary(756.85);

        Employee emp2 = new Employee("The Dog", "Goofy");
        emp2.setBirthDate("141200A2315");
        emp2.setSalary(150);

        System.out.println(emp1.toString());
        System.out.println("\n\n");
        System.out.println(emp2.toString());
        System.out.println("\n\n");

        Student op1 = new Student("Duck", "Donald");
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 4, 25.0, true);
        
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


        StudentCourse [] arrbach = new StudentCourse [] {studentCourse1, studentCourse2, studentCourse3, studentCourse4, studentCourse5 };

        List<StudentCourse> bachelorCourses = new ArrayList<>(Arrays.asList(arrbach));

        StudentCourse [] arrmas = new StudentCourse [] {studentCourse6, studentCourse7, studentCourse8, studentCourse9, studentCourse10, studentCourse11 };

        List<StudentCourse> masterCourses = new ArrayList<>(Arrays.asList(arrmas));

        op1.setDegreeTitle(0,"Bachelor of Science");
        op1.setDegreeTitle(1,"Master of Science");
        op1.setTitleOfThesis(0,"Bachelor thesis title");
        op1.setTitleOfThesis(1,"Master thesis title");

        op1.addCourses(0, bachelorCourses);
        op1.addCourses(1, masterCourses);

        op1.setstartYear(2001);

        System.out.println(op1.toString());
        System.out.println("\n\n");

        op1.setBirthDate("230498-045T");
        op1.setGraduationYear(2020);

        op1.setTitleOfThesis(0,"Christmas - The most wonderful time of the year");
        op1.setTitleOfThesis(1,"Dreaming of a white Christmas");
        
        

        System.out.println(op1.toString());
        System.out.println("\n\n");
        op1.printDegrees();
        System.out.println("\n\n");
        op1.printCourses();
    }
    */
   

    public static void test2 () {

		ResponsibleTeacher teacher = new ResponsibleTeacher("Mouse","Mickey");
        teacher.setBirthDate("230498-045T");
        MonthlyPayment pay = new MonthlyPayment();
        pay.setSalary(756.85);
        teacher.setPayment(pay);

        AssistantTeacher assistant = new AssistantTeacher("The Dog", "Goofy");
        assistant.setBirthDate("141200A2315");
        HourBasedPayment payAssistant = new HourBasedPayment();
        payAssistant.setHours(11.0);
        payAssistant.setEurosPerHour(3.5);
        assistant.setPayment(payAssistant);

        Student op1 = new Student("Duck", "Donald");

        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 4, 25.0, true);
        
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, true);
        
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        Course course12 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        DesignatedCourse cour1 = new DesignatedCourse(course3,true,2023);
        DesignatedCourse cour2 = new DesignatedCourse(course4,false,2023);
        DesignatedCourse cour3 = new DesignatedCourse(course10,false,2022);
        DesignatedCourse cour4 = new DesignatedCourse(course11,true,2023);

        
        DesignatedCourse [] designatedcourses = new DesignatedCourse [] {cour1, cour2};
        
        List<DesignatedCourse> designatedcoursesteach = new ArrayList<> (Arrays.asList(designatedcourses));
        
        DesignatedCourse [] designatedcourses2 = new DesignatedCourse [] {cour1, cour2};
        
        List<DesignatedCourse> designatedcoursesteach2 = new ArrayList<> (Arrays.asList(designatedcourses2));
        
        teacher.setCourses(designatedcoursesteach);
        assistant.setCourses(designatedcoursesteach);

        System.out.println(teacher.toString());
        System.out.println("\n\n");
        System.out.println(assistant.toString());
        System.out.println("\n\n");
        
        teacher.setCourses(designatedcoursesteach2);
        assistant.setCourses(designatedcoursesteach2);

        System.out.println(teacher.toString());
        System.out.println("\n\n");
        System.out.println(assistant.toString());
        System.out.println("\n\n");

        System.out.println(teacher.getCourses());
        System.out.println("\n\n");
       
        StudentCourse studentCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studentCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studentCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studentCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studentCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studentCourse9 = new StudentCourse(course9, 3, 2021);
        StudentCourse studentCourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse studentCourse11 = new StudentCourse(course11, 'f', 2022);

        StudentCourse studentCourse12 = new StudentCourse(course12, 'f', 2022);
        
        StudentCourse [] arrbach = new StudentCourse [] {studentCourse1, studentCourse2, studentCourse3, studentCourse4, studentCourse5 };

        List<StudentCourse> bachelorCourses = new ArrayList<>(Arrays.asList(arrbach));

        StudentCourse [] arrmas = new StudentCourse [] {studentCourse6, studentCourse7, studentCourse8, studentCourse9, studentCourse10, studentCourse11 };

        List<StudentCourse> masterCourses = new ArrayList<>(Arrays.asList(arrmas));

        StudentCourse [] arrdoc = new StudentCourse [] {studentCourse12};

        List<StudentCourse> docCourses = new ArrayList<>(Arrays.asList(arrdoc));

        op1.setDegreeTitle(0,"Bachelor of Science");
        op1.setDegreeTitle(1,"Master of Science");
        op1.setTitleOfThesis(0,"Bachelor thesis title");
        op1.setTitleOfThesis(1,"Master thesis title");


        op1.addCourses(0, bachelorCourses);
        op1.addCourses(1, masterCourses);

        op1.addCourses(2, docCourses);

        op1.setstartYear(2001);

        op1.setGraduationYear(2020);

        System.out.println(op1.toString());

        System.out.println("\n\n");

        op1.setBirthDate("230498-045T");

        op1.setTitleOfThesis(0,"Christmas - The most wonderful time of the year");
        op1.setTitleOfThesis(1,"Dreaming of a white Christmas");
        
        op1.printDegrees();
        System.out.println("\n\n");
        op1.printCourses();

	}
    
    
    



}