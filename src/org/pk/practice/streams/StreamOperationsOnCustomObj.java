package org.pk.practice.streams;

import org.pk.practice.models.Employee;
import org.pk.practice.models.EmployeeAgeDesignationSalaryDto;
import org.pk.practice.models.EmployeeDummyList;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamOperationsOnCustomObj {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDummyList.getEmployeeList();

        System.out.println();
        System.out.println("List of employees " + employees);
        System.out.println();

        System.out.println("Highest Salary Employee\n " + findTheNthHighestSalariedEmployee(employees, 1));
        System.out.println();

        System.out.println("Second Highest Salary Employee\n " + findTheNthHighestSalariedEmployee(employees, 2));
        System.out.println();

        System.out.println("Lowest Salary Employee\n " + findTheLowestNthSalariedEmployee(employees, 1));
        System.out.println();

        System.out.println("Second Lowest Salary Employee\n " + findTheLowestNthSalariedEmployee(employees, 2));
        System.out.println();

        System.out.println("Employee Age less than 30\n " + findEmployeeAgeLessThan(employees, 30));
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

    static Employee findTheLowestNthSalariedEmployee(List<Employee> employees, int nth) {
        if (nth <= 0 || nth > employees.size()) {
            throw new RuntimeException("Invalid rank passed");
        }
        return employees
                .stream()
                .sorted()
                .toList()
                .stream()
                .skip(nth - 1)
                .findFirst()
                .orElse(null);
    }

    static List<EmployeeAgeDesignationSalaryDto> findEmployeeAgeLessThan(List<Employee> employees, int age) {
        if (age <= 22 || age > 60) {
            throw new RuntimeException("Age must be between 22 to 60");
        }
        return employees
                .stream()
                .filter(getAgeLowerThanPredicate(age))
                .sorted(Comparator.reverseOrder())
                .map(StreamOperationsOnCustomObj::employeeToDtoMapper)
                .toList();
    }

    static EmployeeAgeDesignationSalaryDto employeeToDtoMapper(Employee e) {
        return new EmployeeAgeDesignationSalaryDto(e.getId(), e.getFirstName(), e.getLastName(), getAge(e.getDob()), e.getDesignation());
    }

    static Predicate<Employee> getAgeLowerThanPredicate(int age) {
        return (Employee e) -> getAge(e.getDob()) <= age;
    }

    static int getAge(LocalDate dob) {
        return LocalDate.now().getYear() - dob.getYear();
    }
}
