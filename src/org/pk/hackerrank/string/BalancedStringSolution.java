package org.pk.hackerrank.string;

import java.util.*;

public class BalancedStringSolution {

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
//        String str = """
//                ({}[])
//                (({()})))
//                ({(){}()})()({(){}()})(){()}
//                {}()))(()()({}}{}
//                }}}}
//                ))))
//                {{{
//                (((
//                []{}(){()}((())){{{}}}{()()}{{}{}}
//                [[]][][]
//                }{
//                """;
        // test case 2
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
        String[] lines = str.split("\n");
        List<String> list = List.of(lines);
        list.forEach(s -> {
            System.out.println("Output: " + s + "  " + validate(s));
        });
    }

    private static char respectiveClosingBracket(char c) {
        char closChar = ' ';
        switch (c) {
            case '{':
                closChar = '}';
                break;

            case '}':
                closChar = '{';
                break;
            case '(':
                closChar = ')';
                break;
            case ')':
                closChar = '(';
                break;
            case '[':
                closChar = ']';
                break;
            case ']':
                closChar = '[';
                break;
        }
        return closChar;
    }

    public static boolean isStringBalanced(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, ++count);
            } else {
                map.put(ch, 1);
            }
        }
        if (map.entrySet().isEmpty()) {
            return false;
        }
        return map.entrySet().stream().allMatch(characterIntegerEntry -> {
            Character ch = characterIntegerEntry.getKey();
            char rcb = respectiveClosingBracket(ch);
            Integer rcbCount = map.get(rcb);
            return Objects.equals(rcbCount, characterIntegerEntry.getValue());
        });
    }

    public static boolean validate(String input) {
        Stack<String> stack = new Stack<>();
        List<String> characterList = new ArrayList<>(Arrays.asList(input.split("")));
        StringBuilder compareStr = new StringBuilder();
        characterList.forEach(c -> {
            switch (c) {
                case "(":
                    stack.push(c);
                    compareStr.append(c);
                    break;
                case "{":
                    stack.push(c);
                    compareStr.append(c);
                    break;
                case "[":
                    stack.push(c);
                    compareStr.append(c);
                    break;
                case ")":
                    if (!stack.empty() && stack.peek().equals("(")) {
                        compareStr.append(c);
                        stack.pop();
                    }
                    break;
                case "}":
                    if (!stack.empty() && stack.peek().equals("{")) {
                        compareStr.append(c);
                        stack.pop();
                    }
                    break;
                case "]":
                    if (!stack.empty() && stack.peek().equals("[")) {
                        compareStr.append(c);
                        stack.pop();
                    }
                    break;
            }
        });
        if (!compareStr.toString().equals(input)) {
            return false;
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
