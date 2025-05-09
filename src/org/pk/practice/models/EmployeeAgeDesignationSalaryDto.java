package org.pk.practice.models;

public class EmployeeAgeDesignationSalaryDto {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Designation designation;

    public EmployeeAgeDesignationSalaryDto() {
    }

    public EmployeeAgeDesignationSalaryDto(int id, String firstName, String lastName, int age, Designation designation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.designation = designation;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }


    @Override
    public String toString() {
        return "EmployeeAgeDesignationSalaryDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", designation=" + designation +
                '}';
    }
}
