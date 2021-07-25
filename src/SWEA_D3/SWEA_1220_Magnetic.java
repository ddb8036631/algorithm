package SWEA_D3;

import java.util.Scanner;

public class SWEA_1220_Magnetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int j = 0; j < N; j++) {
                boolean start = false;

                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 1) {
                        start = true;
                    } else if (map[i][j] == 2 && start) {
                        start = false;
                        cnt++;
                    }
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
}
