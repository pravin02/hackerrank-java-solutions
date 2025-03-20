package org.pk.hackerrank.datastructure;

import java.util.*;


class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }


}

class StudentComparator implements Comparator<Student> {

//    @Override
//    public int compare(Student o1, Student o2) {
//        if (o1.getCgpa() > o2.getCgpa()) {
//            return -1;
//        } else if (o1.getCgpa() < o2.getCgpa()) {
//            return 1;
//        }
//        return 0;
//    }

    @Override
    public int compare(Student s1, Student s2) {
        if (Double.compare(s2.getCgpa(), s1.getCgpa()) == 0) {
            if (s1.getName().compareTo(s2.getName()) == 0) {
                return Integer.compare(s1.getId(), s2.getId());
            } else {
                return s1.getName().compareTo(s2.getName());
            }
        } else {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }
    }
}

class Priorities {

    /**
     * Sample Input 0
     * 12
     * ENTER John 3.75 50
     * ENTER Mark 3.8 24
     * ENTER Shafaet 3.7 35
     * SERVED
     * SERVED
     * ENTER Samiha 3.85 36
     * SERVED
     * ENTER Ashley 3.9 42
     * ENTER Maria 3.6 46
     * ENTER Anik 3.95 49
     * ENTER Dan 3.95 50
     * SERVED
     * <p>
     * Sample Output 0
     * Dan
     * Ashley
     * Shafaet
     * Maria
     * <p>
     * Explanation 0
     * In this case, the number of events is 12. Let the name of the queue be Q.
     * <p>
     * John is added to Q. So, it contains (John, 3.75, 50).
     * Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).
     * Shafaet is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Shafaet, 3.7, 35).
     * Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Shafaet, 3.7, 35).
     * John is served next as he has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
     * Samiha is added to Q. So, it contains (Shafaet, 3.7, 35) and (Samiha, 3.85, 36).
     * Samiha is served as she has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
     * Now, four more students are added to Q. So, it contains (Shafaet, 3.7, 35), (Ashley, 3.9, 42), (Maria, 3.6, 46), (Anik, 3.95, 49), and (Dan, 3.95, 50).
     * Anik is served because though both Anil and Dan have the highest CGPA but Anik comes first when sorted in alphabetic order. So, Q contains (Dan, 3.95, 50), (Ashley, 3.9, 42), (Shafaet, 3.7, 35), and (Maria, 3.6, 46).
     * As all events are completed, the name of each of the remaining students is printed on a new line.
     *
     * @param events
     * @return
     */
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> students = new PriorityQueue<>(events.size(), new StudentComparator());
        for (String event : events) {
            String[] studentDetails = event.split(" ");
            String priority = studentDetails[0];
            if ("ENTER".equals(priority)) {
                Student student = new Student(Integer.parseInt(studentDetails[3]), studentDetails[1], Double.parseDouble(studentDetails[2]));
                students.add(student);
            } else if ("SERVED".equals(priority)) {
                students.poll();
            }
        }

        List<Student> list = new ArrayList<>(students);
        list.sort(students.comparator());
        return list;
    }
}

public class PriorityQueueSolution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
//        int totalEvents = Integer.parseInt(scan.nextLine());
//        list<String> events = new ArrayList<>();
//
//        while (totalEvents-- != 0) {
//            String event = scan.nextLine();
//            events.add(event);
//        }

        String input = """
                12
                ENTER John 3.75 50
                ENTER Mark 3.8 24
                ENTER Shafaet 3.7 35
                SERVED
                SERVED
                ENTER Samiha 3.85 36
                SERVED
                ENTER Ashley 3.9 42
                ENTER Maria 3.6 46
                ENTER Anik 3.95 49
                ENTER Dan 3.95 50
                SERVED
                """;

        String[] lines = input.split("\n");
        List<String> events = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            events.add(lines[i]);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}