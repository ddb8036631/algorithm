package 프로그래머스_Level2;

import java.util.Stack;

public class 올바른괄호 {
    public static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.empty()) stack.push(c);
            else {
                if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(c);
            }
        }

        answer = stack.size() == 0 ? true : false;

        return answer;
    }

    public static void main(String[] args) {
//        String s = "()()";
//        String s = "(())()";
//        String s = ")()(";
        String s = "(()(";

        System.out.println(solution(s));
    }
}
