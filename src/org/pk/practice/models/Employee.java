package org.pk.practice.models;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Employee implements Comparable<Employee> {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Designation designation;
    private double ctc;
    private boolean isActive;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, LocalDate dob, Designation designation, double ctc, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.designation = designation;
        this.ctc = ctc;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public double getCtc() {
        return ctc;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public int compareTo(Employee e) {
        return Double.compare(this.getCtc(), e.getCtc());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && Double.compare(ctc, employee.ctc) == 0 && isActive == employee.isActive && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(dob, employee.dob) && designation == employee.designation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dob, designation, ctc, isActive);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", designation=" + designation +
                ", ctc=" + ctc +
                ", isActive=" + isActive +
                '}';
    }
}
