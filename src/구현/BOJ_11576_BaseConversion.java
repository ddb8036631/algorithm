package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11576_BaseConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int sum = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) deque.add(Integer.parseInt(st.nextToken()));

        while (!deque.isEmpty()) {
            int size = deque.size();
            int num = deque.poll();

            sum += (int) Math.pow(A, size - 1) * num;
        }

        while (sum != 0) {
            deque.push(sum % B);
            sum /= B;
        }

        while (!deque.isEmpty()) answer.append(deque.pop() + " ");

        System.out.println(answer);
    }
}
