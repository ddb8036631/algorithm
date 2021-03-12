package 카카오2020;

import java.util.Stack;

public class 괄호변환 {
    public static String solution(String p) {
        String answer = divide(p);

        return answer;
    }

    static String divide(String p) {
        if (p.length() == 0) return "";

        int endIdx = getEndIdx(p) + 1;
        String u = p.substring(0, endIdx);
        String v = p.substring(endIdx);

        if (isRight(u)) {
            return u + divide(v);
        } else {
            StringBuilder tmp = new StringBuilder("(");
            tmp.append(divide(v));
            tmp.append(")");

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') tmp.append(")");
                else tmp.append("(");
            }

            return tmp.toString();
        }
    }

    static int getEndIdx(String p) {
        int left = 0, right = 0, idx = 0;

        while (idx < p.length()) {
            if (p.charAt(idx) == '(') left++;
            else if (p.charAt(idx) == ')') right++;

            if (left == right) break;

            idx++;
        }

        return idx;
    }

    static boolean isRight(String u) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') stack.push('(');
            else if (!stack.isEmpty()) stack.pop();
        }

        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        solution("(()())()");
//        solution(")(");
//        solution("()))((()");
    }
}
