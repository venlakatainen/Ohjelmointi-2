public abstract class Person {

    // attributes
    String firstName = ConstantValues.NO_NAME;
    String lastName = ConstantValues.NO_NAME;
    String birthDate = ConstantValues.NO_BIRTHDATE;

    // constructor
    public Person (String lname, String fname) {
        if (lname != null && fname != null) { 
            firstName = fname;
            lastName = lname;
        }
    }

    // methods
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

    // get birthdate
    public String getBirthDate () {
        return birthDate;
    }


    // set birthdate
    public String setBirthDate (String personId) {
        PersonID pID = new PersonID();

        if (personId == null) {
            return "No change";
        }
        pID.setPersonID(personId);

        if (pID.getBirthDate() == ConstantValues.NO_BIRTHDATE) {
            return "No change";
        }

        this.birthDate = pID.getBirthDate();
        return pID.getBirthDate();
    }

    protected int getRandomId (final int min, final int max) {
        int id = (int) ((Math.random() * (max - min)) + min);  
        return id;
    }

    abstract public String getIdString();

}