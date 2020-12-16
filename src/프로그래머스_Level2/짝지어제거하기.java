package 프로그래머스_Level2;

import java.util.Stack;

public class 짝지어제거하기 {
    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else
                    stack.push(s.charAt(i));
            }
        }

        if (stack.size() == 0)
            answer = 1;

        return answer;
    }

    public static void main(String[] args) {
//        String s = "baabaa";
        String s = "cdcd";

        System.out.println(solution(s));
    }
}
