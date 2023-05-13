//package dev.m3s.programming2.homework3;
public class HourBasedPayment implements Payment {

    // attributes
    double eurosPerHour;
    double hours;

    //methods

    // get euros per hour
    public double getEurosPerHour () {
        return eurosPerHour;
    }

    // set euros per hour
    public void setEurosPerHour (double eurosPerHour) {
        if (eurosPerHour > 0.0) {
            this.eurosPerHour = eurosPerHour;
        }
    }

    // get hours
    public double getHours () {
        return hours;
    }

    // set hours
    public void setHours (double hours) {
        if (hours > 0.0) {
            this.hours = hours;
        }
    }

    // calculate payment
    public double calculatePayment () {
        return hours*eurosPerHour;
    }
}
