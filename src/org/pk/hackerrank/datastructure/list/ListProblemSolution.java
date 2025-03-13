package org.pk.hackerrank.datastructure.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListProblemSolution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter size of list: ");
        int no = scanner.nextInt();
        //System.out.println("Enter elements in list: ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < no; i++) {
            list.add(scanner.nextInt());
        }
        //System.out.println("Enter no of queries: ");
        int queries = scanner.nextInt();

        while (queries-- > 0) {
          //  System.out.println("Enter Values Insert/Delete: ");
            String action = scanner.next();
            if ("Insert".equals(action)) {                
            //    System.out.println("Enter Index & value: ");
                int index = scanner.nextInt();
                int element = scanner.nextInt();
                list.add(index, element);
            } else if ("Delete".equals(action)) {
              //  System.out.println("Enter Index to remove value: ");
                int index = scanner.nextInt();
                list.remove(index);
            }            
        }
        list.forEach(lno -> System.out.print(lno + " "));
        scanner.close();
    }
}
