package org.pk.hackerrank.datastructure;

import java.util.Stack;

public class BracketProblemSolution {

    private static char matchingClosingBracket(char c) {
        char corChar = ' ';
        switch (c) {
            case '{':
                corChar = '}';
                break;
            case '}':
                corChar = '{';
                break;
            case '(':
                corChar = ')';
                break;
            case ')':
                corChar = '(';
                break;
            case '[':
                corChar = ']';
                break;
            case ']':
                corChar = '[';
                break;
        }
        return corChar;
    }

    public static boolean balancedBrackets(String s) {
        char arr[] = s.toCharArray();
        int i = 0;
        boolean result = false;
        while (i < arr.length) {
            char corChar = matchingClosingBracket(arr[i]);
            i++;
            if (s.contains(String.valueOf(corChar))) {
                result = true;
                continue;
            } else {
                return result = false;
            }
        }
        return result;
    }

    public static void main(String[] argh) {
        /*
         * Scanner sc = new Scanner(System.in);
         *
         * stack<String> stack = new stack<>(); while (sc.hasNext()) { String input =
         * sc.next(); stack.push(input);
         *
         * String popedString = stack.pop();
         * System.out.println(balancedBrackets(popedString)); } sc.close();
         */
        // test case 0
//        String str = """
//                {}()
//                ({()})
//                {}(
//                []
//                """;

        // Test case 1
        String str = """
                ({}[])
                (({()})))
                ({(){}()})()({(){}()})(){()}
                {}()))(()()({}}{}
                }}}}
                ))))
                {{{
                (((
                []{}(){()}((())){{{}}}{()()}{{}{}}
                [[]][][]
                }{
                """;
        // test case 2 need to  unlock
//        String str = """
//
//                """;
        Stack<String> stack = new Stack<>();
        // test case 1
        String[] lines = str.split("\n");
        for (String line : lines) {
            stack.push(line);
        }

        String s = null;
        while (!stack.isEmpty() && (s = stack.pop()) != null) {
            System.out.println(s + "  " + balancedBrackets(s));
        }

    }
}
