//package dev.m3s.programming2.homework3;
public class MonthlyPayment implements Payment {

    // attributes
    private double salary; 

    // methods

    // get salary
    public double getSalary () {
        return salary;
    }

    // set salary
    public void setSalary (double salary) {
        if (salary > 0.0) {
            this.salary = salary;
        }
    }

    // calculate payment
    public double calculatePayment () {
        return getSalary();
    }
}
