package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17837_새로운게임2 {
    static int N, K;
    static int[][] color;
    static int[][] marker;
    static String[][] board;

    static int[] di = {0, 0, 0, -1, 1};
    static int[] dj = {0, 1, -1, 0, 0};

    static boolean exit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        color = new int[N + 1][N + 1];
        marker = new int[K][3];
        board = new String[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(board[i], "");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                color[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            marker[i][0] = sc.nextInt();
            marker[i][1] = sc.nextInt();
            marker[i][2] = sc.nextInt();

            board[marker[i][0]][marker[i][1]] = Integer.toString(i);
        }

        int turn = 0;

        while (++turn <= 1000) {
            for (int i = 0; i < K; i++) {
                int now_i = marker[i][0];
                int now_j = marker[i][1];
                int now_dir = marker[i][2];

                int next_i = now_i + di[now_dir];
                int next_j = now_j + dj[now_dir];

                if (!check(next_i, next_j) || color[next_i][next_j] == 2) {
                    marker[i][2] = now_dir = changeDirection(now_dir);

                    int next_next_i = now_i + di[now_dir];
                    int next_next_j = now_j + dj[now_dir];

                    if (check(next_next_i, next_next_j) && color[next_next_i][next_next_j] != 2) {
                        move(i, now_i, now_j, next_next_i, next_next_j);
                    }
                }

                else {
                    move(i, now_i, now_j, next_i, next_j);
                }
            }

            if (exit) break;
        }

        System.out.println(exit ? turn : -1);
    }

    private static void move(int k, int now_i, int now_j, int next_i, int next_j) {
        int beginIndex = board[now_i][now_j].indexOf(Integer.toString(k));

        for (int i = beginIndex; i < board[now_i][now_j].length(); i++) {
            int num = Integer.parseInt(String.valueOf(board[now_i][now_j].charAt(i)));

            marker[num][0] = next_i;
            marker[num][1] = next_j;
        }

        if (color[next_i][next_j] == 0) {
            board[next_i][next_j] += board[now_i][now_j].substring(beginIndex);
        }

        else if (color[next_i][next_j] == 1) {
            StringBuilder sb = new StringBuilder(board[now_i][now_j].substring(beginIndex));
            board[next_i][next_j] += sb.reverse();
        }

        board[now_i][now_j] = board[now_i][now_j].substring(0, beginIndex);

        if (board[next_i][next_j].length() >= 4) {
            exit = true;
        }
    }

    private static boolean check(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N) return false;
        return true;
    }

    private static int changeDirection(int dir) {
        if (dir == 1) return 2;
        else if (dir == 2) return 1;
        else if (dir == 3) return 4;
        else return 3;
    }
}

