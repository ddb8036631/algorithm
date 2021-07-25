package 구현;

import java.util.Scanner;

public class BOJ_21771_가희야거기서자는거아니야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int Rg = sc.nextInt();
        int Cg = sc.nextInt();
        int Rp = sc.nextInt();
        int Cp = sc.nextInt();
        char[][] map = new char[R][C];
        int cnt = 0;

        for (int i = 0; i < R; i++) map[i] = sc.next().toCharArray();

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (map[i][j] == 'P') cnt++;

        System.out.println(cnt == Rp * Cp ? 0 : 1);
    }
}
