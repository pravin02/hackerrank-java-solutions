package org.pk.practice.models;

import java.time.LocalDate;

public class Manager extends Employee implements CalculateBonus {

    public Manager() {
        super.setDesignation(Designation.MANAGER);
    }

    public Manager(int id, String firstName, String lastName, LocalDate dob, double ctc, boolean isActive) {
        super(id, firstName, lastName, dob, Designation.MANAGER, ctc, isActive);
    }

    @Override
    public double calculateBonus() {
        if (getCtc() <= 20) {
            return getCtc() * 20 / 100;
        } else if (getCtc() >= 25 && getCtc() <= 30) {
            return getCtc() * 14 / 100;
        } else if (getCtc() > 30 && getCtc() <= 35) {
            return getCtc() * 12 / 100;
        } else if (getCtc() > 35) {
            return getCtc() * 10 / 100;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
