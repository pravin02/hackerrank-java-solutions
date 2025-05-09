package org.pk.practice.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeDummyList {

    public static List<Employee> getEmployeeList() {
        return Arrays.asList(
                new Developer(1, "Pravin", "Patil", LocalDate.of(1991, 12, 2), 3000000.0, true),
                new Developer(3, "Devendra", "Wani", LocalDate.of(1994, 12, 2), 800000.0, true),
                new Developer(4, "Gajendra", "Thombare", LocalDate.of(1998, 12, 2), 1500000.0, true),

                new Manager(2, "Vishal", "Patil", LocalDate.of(1997, 10, 2), 1800000.0, true),
                new Manager(5, "Rohan", "Thombare", LocalDate.of(1987, 12, 2), 4800000.0, true),
                new Manager(6, "Krishnat", "Molawade", LocalDate.of(1989, 12, 2), 4800000.0, true),

                new SalesMan(7, "Sumit", "Banawalikar", LocalDate.of(1985, 12, 2), 4800000.0, true)

        );
    }
}
