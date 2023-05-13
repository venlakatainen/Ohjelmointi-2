import java.math.BigDecimal;
import java.math.RoundingMode;


public class Employee extends Person implements Payment {

    //attributes
    String empId;
    int startYear = 2023;
    double salary;
    //Payment payment;

    // constructor
    public Employee (String lname, String fname) {
        super(lname, fname);
        empId = "OY_" + Integer.toString(getRandomId(2001, 3000));
    }

    // methods
    // get id string
    public String getIdString () {
        return empId;
    }

    // get start year
    public int getStartYear() {
        return startYear;
    }

    // set start year
    public void setStartYear (final int startYear) {
        if (startYear > 2000 && startYear <= 2023 ) {
            this.startYear = startYear;
        }
    }

    // get salary
    public double getSalary () {
        return salary;
    }

    // set salary
    public void setSalary (final double salary) {
        if (salary > 0.0) {
            this.salary = salary;
        }
    }

    /* 
    public Payment getPayment () {
        return payment;
    }

    public void setPayment (Payment payment) {
        if (payment != null ) {
            this.payment = payment;
        }

    }
    */
    public double calculatePayment () {
        double pay = 1.5* salary;

        BigDecimal pay2 = new BigDecimal(pay);
        BigDecimal salary2 = pay2.setScale(2, RoundingMode.HALF_UP);

        return salary2.doubleValue();
    }

    public String getEmployeeIdString () {
        return empId.substring(0,3);
    }


    public String toString () {
        String employeesalary = Double.toString(calculatePayment());
        employeesalary = employeesalary.replace(',', '.');
        return "Employee id: " + getIdString() 
        + "\n   First name: " + firstName + ", Last name: " + lastName 
        + "\n   Birthdate: " + getBirthDate()
        + "\n   Start year: " + getStartYear()
        + "\n   Salary: " + employeesalary;
    }
    //abstract protected String getEmployeeIdString();
}