package org.pk.hackerrank.datastructure.stack;

import java.util.Stack;

public class BracketProblemSolution {

    private static char corrospondingCloningBracket(char c) {
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
            char corChar = corrospondingCloningBracket(arr[i]);
            // System.out.println("String is " + s + " corchar " + corChar + " for " +
            // arr[i]);
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
        String str= """
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
        Stack<String> stack = new Stack<>();
        // test case 1
        String[] lines =str.split("\n");
        for(String line: lines) {
            stack.push(line);
        }

        String s = null;
        while (!stack.isEmpty() && (s = stack.pop()) != null) {
            System.out.println(s + "  " + balancedBrackets(s));
        }

    }
}
