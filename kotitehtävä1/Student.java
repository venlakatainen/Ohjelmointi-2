//package dev.m3s.programming2.homework1;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.RunElement;
import java.util.Random;

public class Student {

    // attributes
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id;
    private double bachelorCredits;
    private double masterCredits;
    private String titleOfMastersThesis = ConstantValues.NO_TITLE;
    private String titleOfBachelorsThesis = ConstantValues.NO_TITLE;
    private int startYear = 2023;
    private int graduationYear;
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    private String status;
    


    // student constructors
    public Student() {
        id = getRandomId(); 
    }

    public Student(String lname, String fname) {
        id = getRandomId();
        // set given first and last name
        firstName = fname;
        lastName = lname;
    }

    // methods
    
    // get first name
    public String getFirstName() {
        return firstName;
    }

    // set first name
    public void setFirstName(String firstName) {

        if (firstName != null){
            this.firstName = firstName;
        }
    }

    //get last name
    public String getLastName () {
        return lastName;
    }

    //set last name
    public void setLastName (String lastName) {
        
        if (lastName != null){
            this.lastName = lastName;
        }
    }

    // get student id
    public int getID () {
        return id;
    }

    // set student id
    public void setId (final int id) {
        if (id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID){
            this.id = id;
        }
    }

    // get bachelor credits
    public double getBachelorCredits () {
        return bachelorCredits;
    }


    // set bachelor credits
    public void setBachelorCredits(final double bachelorCredits) {
        if (bachelorCredits >= ConstantValues.MIN_CREDITS && bachelorCredits <= ConstantValues.MAX_CREDITS){
            this.bachelorCredits = bachelorCredits;
        }
    }
    // get master credits
    public double getMasterCredits () {
        return masterCredits;
    }

    // set master credits
    public void setMasterCredits(final double masterCredits) {
        if (masterCredits >= ConstantValues.MIN_CREDITS && masterCredits <= ConstantValues.MAX_CREDITS){
            this.masterCredits = masterCredits;
        }
    }

    // get title of master's thesis
    public String getTitleOfMastersThesis () {
        return titleOfMastersThesis;
    }

    // set title of master's thesis
    public void setTitleOfMasterThesis (String title) {
        if (title != null){
            titleOfMastersThesis = title;
        }   
    }

    // get title of bachelor's thesis
    public String getTitleOfBachelorThesis () {
        return titleOfBachelorsThesis;
    }

    // set title of bachelor's thesis
    public void setTitleOfBachelorThesis (String title) {
        if (title != null){
            titleOfBachelorsThesis = title;
        }   
    }

    // get start year
    public int getstartYear () {
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
        }
        
        if (bachelorCredits < ConstantValues.BACHELOR_CREDITS || masterCredits < ConstantValues.MASTER_CREDITS || titleOfBachelorsThesis == ConstantValues.NO_TITLE || titleOfMastersThesis == ConstantValues.NO_TITLE){
            return "Check the required studies";
        }

        else {
            return "Check graduation year";
        }
    }

    // check can graduate
    private boolean canGraduate () {
        if (bachelorCredits >= ConstantValues.BACHELOR_CREDITS && masterCredits >= ConstantValues.MASTER_CREDITS){
            if (titleOfBachelorsThesis != ConstantValues.NO_TITLE && titleOfMastersThesis != ConstantValues.NO_TITLE) {
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

    // get study years
    public int getStudyYears () {
        if (hasGraduated() == true){
            return graduationYear - startYear;
        }
        else {
            return 2023 - startYear;
        }
    }

    // get random id
    private int getRandomId () {
        Random rand = new Random();
        id = rand.nextInt((ConstantValues.MAX_ID - ConstantValues.MIN_ID) + 1) + ConstantValues.MIN_ID;
        return id;
    }

    // set person id
    public String setPersonId (final String ID) {
        
        if (checkPersonIdNumber(ID) == true) {
            // birthday to dd.mm.yyyy 
            String year = "";
            StringBuilder days = new StringBuilder();
            days.append(ID.charAt(0)); 
            days.append(ID.charAt(1));
            String day = days.toString();

            StringBuilder months = new StringBuilder();
            months.append(ID.charAt(2)); 
            months.append(ID.charAt(3));
            String month = months.toString();

            StringBuilder yearShort = new StringBuilder();
            yearShort.append(ID.charAt(4)); 
            yearShort.append(ID.charAt(5));
            String years = yearShort.toString();
            
            if (ID.charAt(6) == '+') {
                year = "18" + years;
            }
            else if (ID.charAt(6) == '-') {
                year = "19" + years;
            }
            else if (ID.charAt(6) == 'A') {
                year = "20" + years;
            }

            StringBuilder formBirthday = new StringBuilder();
            char dot = '.';
            
            formBirthday.append(day);
            formBirthday.append(dot);
            formBirthday.append(month);
            formBirthday.append(dot);
            formBirthday.append(year);

            String birthday = formBirthday.toString();
            
            // check if birthday is valid
            if (checkBirthdate(birthday) == true) {
                // check if last char is correct
                if (isValidChar(ID) == true){
                    birthDate = birthday;
                    return "Ok";
                }
                else {
                    return "Incorrect check mark!";
                }
            }
            else {
                return "Invalid birthday!";
            }
        }
        return "Invalid birthday!";
    }

    // check person id number
    private boolean checkPersonIdNumber(final String checkID){
        // check if length is correct
        if (checkID.length() != 11) {
            return false;
        }
        else {
            // check if the middle mark is correct
            if (checkID.charAt(6) == '+' || checkID.charAt(6) == '-' || checkID.charAt(6) == 'A'){
                return true;
            } 
            return false;
        }
    }

    // check birthday
    private boolean checkBirthdate(final String date){
		
        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
		
        // chekc the basic rules
		if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
		}
		else {
            // months that have only 30 days
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                return false;
            }
            // check february which has normally just 28 days except if the year is leap year
            if (month == 2) {
                if (day > 29) {
                    return false;
                }
                else if (day == 29) {
                    if (isLeapYear(year) == true) { 
                        return true;
                    }
                    else if (isLeapYear(year) == false) {
                        return false;
                    }
                }
            }
		}
		
		return true;
	}

    //check if the last mark is valid
    private boolean isValidChar(final String idCheck){
		
        // chars that the last mark could be
		String possibleChars = "0123456789ABCDEFHJKLMNPRSTUVWXY";
        // first numbers from the id 
		String numbers = idCheck.substring(0,6);
        // connect with the last part numbers after +,- or A
		numbers = numbers + idCheck.substring(7,10);
        // convert string to number
		int number = Integer.parseInt(numbers);
        // divide by 31 to check the remainder
		int remainder = number % 31;
        
        // if the marks match char is valid 
        if (possibleChars.charAt(remainder) == idCheck.charAt(10)) {
            return true;
        }
        // if not the char is not valid
        else {
            return false;
        }
	}

    // check if the year is leap year
    static boolean isLeapYear(int yearcheck){
		// check is year can be divided four
		if (yearcheck % 4 != 0) {
			return false;
		}
        // check if year can be divided 100 or 400
		else {
			if (yearcheck % 100 == 0){
                if (yearcheck % 400 != 0){
				    return false;
                }
            }
		}
		// year is a leap year
		return true;
	}

    // to string
    //@Override
    public String toString() {
        String leftb = "";
        String leftm = "";
		if (hasGraduated() == true) {
            status = "The student has graduated in " + Integer.toString(graduationYear);
        }
        else if (hasGraduated() == false) {
            status = "The student has not graduated, yet.";

        }

        if (bachelorCredits >= ConstantValues.BACHELOR_CREDITS){
            leftb = "  ==> All required bachelor credits completed (" + bachelorCredits + "/180.0)";
        }
        else if (bachelorCredits < ConstantValues.BACHELOR_CREDITS){
            leftb = "  ==> Missing bachelor credits " + (ConstantValues.BACHELOR_CREDITS - bachelorCredits) + " (" + bachelorCredits +"/180)";
        }

        if (masterCredits >= ConstantValues.MASTER_CREDITS){
            leftm = "  ==> All required master credits completed (" + masterCredits + "/120.0)";
        }
        else if (masterCredits < ConstantValues.MASTER_CREDITS){
            leftm = "  ==> Missing master credits " + (ConstantValues.MASTER_CREDITS - masterCredits) + " (" + masterCredits +"/120)";
        }


		return  
        "Student id: " + id
        + "\nFirstName: " + firstName 
        + ", LastName: " + lastName 
        + "\nDate of birth: " + birthDate
        + "\nStatus: "  + status
        + "\nStartYear: " + startYear + " (studies have lasted for " + getStudyYears() + " years)" 
        + "\nBachelor Credits: " + bachelorCredits + leftb
        + "\nMaster Credits: " + masterCredits + leftm
        + "\nTitle of the master's thesis: " + titleOfMastersThesis
        + "\nTitle of the bachelor's thesis: " + titleOfBachelorsThesis;
        	
	}

}