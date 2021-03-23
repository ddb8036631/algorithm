package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_5397_키로거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            String str = sc.next();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (ch == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (ch == '-') {
                    if (!left.isEmpty()) left.pop();
                } else left.push(ch);
            }

            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) left.push(right.pop());
            while (!left.isEmpty()) sb.append(left.pop());

            System.out.println(sb.reverse());
        }
    }
}
