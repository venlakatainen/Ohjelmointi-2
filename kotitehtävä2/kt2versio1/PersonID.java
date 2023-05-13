//package dev.m3s.programming2.homework2;
public class PersonID {

    // attributes
    public String birthDate = ConstantValues.INVALID_BIRTHDAY;

    // methods

    // get birthdate
    public String getBirthDate() {
        return birthDate;
    }

    // set PersonID
    public String setPersonID (final String personID) {
        
        if (checkPersonIDNumber(personID) == true) {
            // birthday to dd.mm.yyyy 
            String year = "";
            StringBuilder days = new StringBuilder();
            days.append(personID.charAt(0)); 
            days.append(personID.charAt(1));
            String day = days.toString();

            StringBuilder months = new StringBuilder();
            months.append(personID.charAt(2)); 
            months.append(personID.charAt(3));
            String month = months.toString();

            StringBuilder yearShort = new StringBuilder();
            yearShort.append(personID.charAt(4)); 
            yearShort.append(personID.charAt(5));
            String years = yearShort.toString();
            
            if (personID.charAt(6) == '+') {
                year = "18" + years;
            }
            else if (personID.charAt(6) == '-') {
                year = "19" + years;
            }
            else if (personID.charAt(6) == 'A') {
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
                if (checkValidCharacter(personID) == true){
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
    private boolean checkPersonIDNumber(final String checkID){
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
                    if (checkLeapYear(year) == true) { 
                        return true;
                    }
                    else if (checkLeapYear(year) == false) {
                        return false;
                    }
                }
            }
		}
		
		return true;
	}

    //check if the last mark is valid
    private boolean checkValidCharacter (final String personID){
		
        // chars that the last mark could be
		String possibleChars = "0123456789ABCDEFHJKLMNPRSTUVWXY";
        // first numbers from the id 
		String numbers = personID.substring(0,6);
        // connect with the last part numbers after +,- or A
		numbers += personID.substring(7,10);
        // convert string to number
		int number = Integer.parseInt(numbers);
        // divide by 31 to check the remainder
		int remainder = number % 31;
        
        // if the marks match char is valid 
        if (possibleChars.charAt(remainder) == personID.charAt(10)) {
            return true;
        }
        // if not the char is not valid
        else {
            return false;
        }
	}

    // check if the year is leap year
    static boolean checkLeapYear(int year){
		// check is year can be divided four
		if (year % 4 != 0) {
			return false;
		}
        // check if year can be divided 100 or 400
		else {
			if (year % 100 == 0){
                if (year % 400 != 0){
				    return false;
                }
            }
		}
		// year is a leap year
		return true;
	}

}