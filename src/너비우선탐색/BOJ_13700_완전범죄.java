package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13700_완전범죄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int D = sc.nextInt();
        int F = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();
        boolean[] police = new boolean[N + 1];
        boolean[] visit = new boolean[N + 1];
        int answer = 0;

        for (int i = 0; i < K; i++) police[sc.nextInt()] = true;

        Queue<int[]> q = new LinkedList<>();
        visit[S] = true;
        q.add(new int[]{S, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == D) {
                answer = now[1];
                break;
            }

            int front = now[0] + F;
            if (front <= N && !police[front] && !visit[front]) {
                visit[front] = true;
                q.add(new int[]{front, now[1] + 1});
            }

            int back = now[0] - B;
            if (back >= 1 && !police[back] && !visit[back]) {
                visit[back] = true;
                q.add(new int[]{back, now[1] + 1});
            }
        }

        System.out.println(answer == 0 ? "BUG FOUND" : answer);
    }
}
