package 이분탐색;

import java.util.Scanner;

public class BOJ_1981_배열에서이동 {
    static int N;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                map[i][j] = sc.nextInt();


    }
}
