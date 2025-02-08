package org.pk.hackerrank.datastructure;

import java.util.BitSet;
import java.util.Map;
import java.util.Scanner;

public class BitSetProblemSolution {

    private static void executeCmd(String cmd, Map<String, BitSet> map, String leftOperand, String rightOperand) {
        switch (cmd) {
            case "AND": {
                map.get(leftOperand).and(map.get(rightOperand));
                break;
            }
            case "OR": {
                map.get(leftOperand).or(map.get(rightOperand));
                break;
            }
            case "XOR": {
                map.get(leftOperand).xor(map.get(rightOperand));
                break;
            }
            case "FLIP": {
                map.get(leftOperand).flip(Integer.parseInt(rightOperand));
                break;
            }
            case "SET": {
                map.get(leftOperand).set(Integer.parseInt(rightOperand));
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bitSetLength = Integer.parseInt(sc.next());
        int noOfOps = Integer.parseInt(sc.next());
        BitSet bitSet1 = new BitSet(bitSetLength);
        BitSet bitSet2 = new BitSet(bitSetLength);
        Map<String, BitSet> map = Map.of("1", bitSet1, "2", bitSet2);
        for (int i = 1; i <= noOfOps; i++) {
            String cmd = sc.next();
            String leftOperand = sc.next();
            String rightOperand = sc.next();
            executeCmd(cmd, map, leftOperand, rightOperand);
            System.out.printf("%d %d\n", bitSet1.cardinality(), bitSet2.cardinality());

        }
        sc.close();
    }

//    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        String input = sc.next();
////        System.out.println(input);
////        sc.close();
//
//        String str = """
//                5 4
//                AND 1 2
//                SET 1 4
//                FLIP 2 2
//                OR 2 1
//                """;
//        String[] lines = str.split("\n");
//        String[] firstRow = lines[0].split(" ");
//        int bitSetLength = Integer.parseInt(firstRow[0]);
//        int noOfOps = Integer.parseInt(firstRow[1]);
//        BitSet bitSet1 = new BitSet(bitSetLength);
//        BitSet bitSet2 = new BitSet(bitSetLength);
//        map<String, BitSet> map = map.of("1", bitSet1, "2", bitSet2);
//        for (int i = 1; i <= noOfOps; i++) {
//            String opLine = lines[i];
//            String[] opDetails = opLine.split(" ");
//            String cmd = opDetails[0];
//            String leftOperand = opDetails[1];
//            String rightOperand = opDetails[2];
//            executeCmd(cmd, map, leftOperand, rightOperand);
//            System.out.printf("%d %d\n", bitSet1.cardinality(), bitSet2.cardinality());
//
//        }
//    }
}
