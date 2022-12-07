package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class 올바른괄호 {

    public static void main(String[] args) {
//        String s = "(())()";
        String s = "()))((()"; // 테스트 케이스 5, 11, 18 유형
//        String s = "(()(";
        solution(s);

    }

    /**
     *
     *
     * @param s '(' 또는 ')' 로만 이루어진 문자열 s
     * @return 문자열 s가 올바른 괄호이면 true
     */
    static boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();

        if (s.length()%2 == 1) {
            return false;
        }

        for(char c : characters) {
            if(c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }
//    static boolean solution(String s) {
//
//        char[] characters = s.toCharArray();
//        char left = '(';
//        char right = ')';
//        Stack<Character> stack = new Stack<>();
//
//        if (s.length()%2 == 1 || characters[0] == right) {
//            return false;
//        }
//
//        int index = 1;
//        for(char c : characters) {
//            if(!stack.isEmpty()) {
//                if(stack.peek() != c){
//                    stack.pop();
//                    System.out.println("(pop) c : " + String.valueOf(c) + " || " + stack);
//                }
//                else {
//                    stack.push(c);
//                    System.out.println("(push) c : " + String.valueOf(c) + " || " + stack);
//                }
//                continue;
//            }
//            stack.push(c);
//            System.out.println("(push) c : " + String.valueOf(c) + " || " + stack);
//        }
//
//        System.out.println(stack);
//
//        if(stack.isEmpty()) {
//            return true;
//        }
//
//        return false;
//    }
}
