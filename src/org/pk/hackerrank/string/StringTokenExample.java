package org.pk.hackerrank.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        StringTokenizer st = new StringTokenizer(s, "A-Z !,?._'@");
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        scan.close();
    }
}
