package 자료구조;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1021_회전하는큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) deque.add(i);

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int targetIdx = deque.indexOf(target);
            int size = deque.size();

            if (targetIdx == -1) continue;

            if (targetIdx <= size / 2) {
                while (deque.peekFirst() != target) {
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
                deque.pollFirst();
            } else {
                while (deque.peekFirst() != target) {
                    deque.addFirst(deque.pollLast());
                    answer++;
                }
                deque.pollFirst();
            }
        }

        System.out.println(answer);
    }
}
