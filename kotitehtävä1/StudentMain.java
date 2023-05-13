//package dev.m3s.programming2.homework1;

public class StudentMain {

    public static void main (String [] args){

        Student opi1 = new Student();
        
        Student opi2 = new Student("Mouse", "Mickey");

        Student opi3 = new Student("Mouse", "Minney");
        
        //test1(opi1, opi2);
        
        //test2(opi1, opi2);
        
        //test3(opi1, opi2);
        
        test4(opi1, opi2, opi3);

    }

    private static void test1(Student op1, Student op2) {
		
		op1.setFirstName("Donald");
        op1.setlastName("Duck");
		op1.setId(330);
        op1.setBachelorCredits(55.0);
        op1.setMasterCredits(14.0);
        op1.setTitleofBachelorThesis("Bachelor thesis title");
        op1.setstartYear(2020);
        op1.setGraduationYear(2021);
        
        op2.setBachelorCredits(5);
        op2.setId(4);
        op2.setTitleofBachelorThesis(null);

        System.out.println(op1);
        System.out.println("\n");
        System.out.println(op2);

	}
	
    private static void test2(Student op1, Student op2) {
		
		op1.setFirstName("Donald");
        op1.setlastName("Duck");
		op1.setId(0);
        op1.setBachelorCredits(180);
        op1.setMasterCredits(180);
        op1.setTitleofMastersThesis("Masters thesis title");
        op1.setTitleofBachelorThesis("Bachelor thesis title");
        op1.setstartYear(2001);
        op1.setGraduationYear(2020);

        System.out.println(op1);
        System.out.println("\n");
        System.out.println(op2);
	}

    private static void test3 (Student op1, Student op2) {
        op1.setFirstName("Donald");
        op1.setlastName("Duck");
		op1.setId(0);
        op1.setBachelorCredits(180);
        op1.setMasterCredits(120);
        op1.setTitleofBachelorThesis("Bachelor thesis title");
        op1.setstartYear(2021);
        op1.setGraduationYear(2021);

        op2.setFirstName(null);
        op2.setlastName(null);
        op2.setBachelorCredits(180);
        op2.setMasterCredits(120);
        op2.setTitleofBachelorThesis("How to survive a bachelors thesis");
        op2.setTitleofMastersThesis("Happy ending");
        op2.setId(101);

        System.out.println(op1);
        System.out.println("\n");
        System.out.println(op2);

        System.out.println(op1.setGraduationYear(2023));
        System.out.println(op2.setGraduationYear(2019));

    }  

    private static void test4 (Student op1, Student op2, Student op3){
        op1.setFirstName("Donald");
        op1.setlastName("Duck");
        op1.setBachelorCredits(120);
        op1.setMasterCredits(180);
        op1.setTitleofMastersThesis("Masters thesis title");
        op1.setTitleofBachelorThesis("Bachelor thesis title");
        op1.setstartYear(2001);
        op1.setGraduationYear(2020);
        
        op2.setPersonId("221199-123K");
        op2.setTitleofBachelorThesis("A new exciting purpose of life");
        op2.setBachelorCredits(65);
        op2.setMasterCredits(22);

        op3.setPersonId("111111-3334");
        op3.setBachelorCredits(215);
        op3.setMasterCredits(120);
        op3.setTitleofMastersThesis("Christmas - The most wonderful time of the year");
        op3.setTitleofBachelorThesis("Dreaming of a white Christmas");
        op3.setstartYear(2018);
        op3.setGraduationYear(2022);

        System.out.println(op1);
        System.out.println("\n");
        System.out.println(op2);
        System.out.println("\n");
        System.out.println(op3);

        System.out.println(op1.setPersonId("This is a string"));
        System.out.println(op1.setPersonId("320187-1234"));
        System.out.println(op1.setPersonId("11111111-3334"));
        System.out.println(op1.setPersonId("121298-830A"));

    }

    
}