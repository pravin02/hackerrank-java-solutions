package org.pk.practice.models;

import java.time.LocalDate;

public class Developer extends Employee implements CalculateBonus {

    public Developer() {
        super.setDesignation(Designation.DEVELOPER);
    }

    public Developer(int id, String firstName, String lastName, LocalDate dob, double ctc, boolean isActive) {
        super(id, firstName, lastName, dob, Designation.DEVELOPER, ctc, isActive);
    }

    @Override
    public double calculateBonus() {
        if (getCtc() <= 20) {
            return getCtc() * 15 / 100;
        } else if (getCtc() >= 20 && getCtc() <= 25) {
            return getCtc() * 14 / 100;
        } else if (getCtc() > 25 && getCtc() <= 30) {
            return getCtc() * 12 / 100;
        } else if (getCtc() > 30) {
            return getCtc() * 10 / 100;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
