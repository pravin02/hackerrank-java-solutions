package org.pk.hackerrank.datastructure.map;
//Complete this code or write your own from scratch

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MapProblemSolution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }

        while (in.hasNext()) {
            String s = in.nextLine();
            Integer no = phoneBook.get(s);
            if (no != null) {
                System.out.println(s + "=" + no);
            } else {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}
