package 구현;

import java.util.Scanner;

public class BOJ_20207_달력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[367];

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            for (int j = S; j <= E; j++) height[j]++;
        }

        int answer = 0, h = 0, w = 0;

        for (int i = 1; i <= 366; i++) {
            if (height[i] == 0) {
                answer += w * h;
                w = h = 0;
                continue;
            }

            h = Math.max(h, height[i]);
            w++;
        }

        System.out.println(answer);
    }
}
