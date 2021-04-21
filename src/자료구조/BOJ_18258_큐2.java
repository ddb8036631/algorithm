package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_18258_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                answer.append(queue.isEmpty() ? "-1" : queue.poll());
                answer.append("\n");
            } else if (command.equals("size")) {
                answer.append(queue.size());
                answer.append("\n");
            } else if (command.equals("empty")) {
                answer.append(queue.isEmpty() ? "1" : "0");
                answer.append("\n");
            } else if (command.equals("front")) {
                answer.append(queue.isEmpty() ? "-1" : queue.peek());
                answer.append("\n");
            } else {
                answer.append(queue.isEmpty() ? "-1" : queue.peekLast());
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }
}
