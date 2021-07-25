package SWEA_D3;

import java.util.Scanner;

public class SWEA_8673_코딩토너먼트1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int K = sc.nextInt();
            int[] players = new int[1 << K];
            int answer = 0;

            for (int i = 0; i < 1 << K; i++) players[i] = sc.nextInt();

            while (K > 0) {
                int[] survived = new int[1 << (K - 1)];

                for (int i = 0; i < 1 << K; i += 2) {
                    survived[i / 2] = Math.max(players[i], players[i + 1]);
                    answer += Math.abs(players[i] - players[i + 1]);
                }

                players = survived;
                K--;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
