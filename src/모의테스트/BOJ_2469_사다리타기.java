package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_2469_사다리타기 {
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        StringBuilder topDown = new StringBuilder();
        StringBuilder bottomUp = new StringBuilder(br.readLine());
        Deque<String> deque = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            topDown.append((char) ('A' + i));
        }

        boolean isFound = false;

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.charAt(0) == '?') {
                isFound = true;
                continue;
            }

            if (isFound) {
                deque.add(command);
            } else {
                topDown = swap(topDown, command);
            }
        }

        while (!deque.isEmpty()) {
            bottomUp = swap(bottomUp, deque.pollLast());
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < topDown.length() - 1; i++) {
            if (topDown.charAt(i) == bottomUp.charAt(i)) answer.append('*');
            else {
                answer.append('-');
                topDown = swap(topDown, i);
            }
        }

        System.out.println(topDown.toString().equals(bottomUp.toString()) ? answer : "x".repeat(K - 1));
    }

    static StringBuilder swap(StringBuilder sb, String command) {
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '-') {
                sb = swap(sb, i);
            }
        }

        return sb;
    }

    static StringBuilder swap(StringBuilder sb, int x) {
        char tmp = sb.charAt(x);
        sb.setCharAt(x, sb.charAt(x + 1));
        sb.setCharAt(x + 1, tmp);

        return sb;
    }
}
