package org.pk.practice.models;

import java.time.LocalDate;

public class SalesMan extends Employee implements CalculateBonus {

    public SalesMan() {
        super.setDesignation(Designation.SALES);
    }

    public SalesMan(int id, String firstName, String lastName, LocalDate dob, double ctc, boolean isActive) {
        super(id, firstName, lastName, dob, Designation.SALES, ctc, isActive);
    }


    @Override
    public double calculateBonus() {
        if (getCtc() <= 10) {
            return getCtc() * 15 / 100;
        } else if (getCtc() >= 15 && getCtc() <= 20) {
            return getCtc() * 14 / 100;
        } else if (getCtc() > 20 && getCtc() <= 25) {
            return getCtc() * 12 / 100;
        } else if (getCtc() > 25) {
            return getCtc() * 10 / 100;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
