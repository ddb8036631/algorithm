package 너비우선탐색;

import java.util.*;

public class BOJ_16953_AB {
    static long A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();

        System.out.println(bfs());
    }

    static long bfs() {
        int cnt = 0;
        Queue<Long> q = new LinkedList<>();
        q.add(A);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                long now = q.poll();

                if (now == B) return cnt + 1;

                if (now * 2 <= B) q.add(now * 2);
                if (now * 10 + 1 <= B) q.add(now * 10 + 1);
            }

            cnt++;
        }

        return -1;
    }
}
