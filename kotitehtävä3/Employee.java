//package dev.m3s.programming2.homework3;
import java.math.BigDecimal;
import java.math.RoundingMode;


public abstract class Employee extends Person implements Payment {

    //attributes
    private String empId;
    private int startYear = 2023;
    private Payment payment;

    // constructor
    public Employee (String lname, String fname) {
        super(lname, fname);
        empId = getEmployeeIdString() + Integer.toString(getRandomId(2001, 3000));
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

    // get payment
    public Payment getPayment () {
        return payment;
    }

    // set payment
    public void setPayment (Payment payment) {
        if (payment != null ) {
            this.payment = payment;
        }

    }

    public double calculatePayment () {
        if (payment != null) {
            return payment.calculatePayment();
        }

        return 0.0;
    }
    
    abstract protected String getEmployeeIdString();
}
