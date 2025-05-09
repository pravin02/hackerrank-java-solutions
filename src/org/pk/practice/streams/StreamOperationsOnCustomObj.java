package org.pk.practice.streams;

import org.pk.practice.models.Employee;
import org.pk.practice.models.EmployeeDummyList;

import java.util.Comparator;
import java.util.List;

public class StreamOperationsOnCustomObj {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDummyList.getEmployeeList();

        System.out.println();
        System.out.println("List of employees " + employees);
        System.out.println();

        System.out.println("Highest Salary Employee\n " + findTheNthHighestSalariedEmployee(employees, 1));
        System.out.println();
    }

    static Employee findTheNthHighestSalariedEmployee(List<Employee> employees, int nth) {
        if (nth <= 0 || nth > employees.size()) {
            throw new RuntimeException("Invalid rank passed");
        }
        return employees
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList()
                .stream()
                .skip(nth - 1)
                .findFirst()
                .orElse(null);
    }

}
