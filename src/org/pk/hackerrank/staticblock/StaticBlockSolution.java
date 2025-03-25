package org.pk.hackerrank.staticblock;

import java.util.Scanner;

public class StaticBlockSolution {

    public static int B = 0;
    public static int H = 0;

    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            if (B <= 0 || H <= 0) {
                throw new Exception("Breadth and height must be positive");
            }
            int area = B * H;
            System.out.print(area);
        } catch (Exception e) {
            System.out.println("java.lang.Exception: " + e.getMessage());
        }
    }
}
