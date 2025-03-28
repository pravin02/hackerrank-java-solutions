package org.pk.hackerrank.file;

import java.util.Scanner;

public class FileProblemSolution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        int count = 1;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(count+" "+scanner.nextLine());
            count++;
        }
    }
}
      
