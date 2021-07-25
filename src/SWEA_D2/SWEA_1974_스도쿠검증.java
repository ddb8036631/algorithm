package SWEA_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1974_스도쿠검증 {
    static final int SIZE = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int[][] map = new int[SIZE][SIZE];
            boolean[][] row = new boolean[SIZE][SIZE + 1];
            boolean[][] col = new boolean[SIZE][SIZE + 1];
            boolean[][] square = new boolean[SIZE][SIZE + 1];

            for (int i = 0; i < SIZE; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            boolean isOK = true;

            outer:
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int num = map[i][j];

                    if (row[i][num] || col[j][num] || square[i / 3 * 3 + j / 3][num]) {
                        isOK = false;
                        break outer;
                    }

                    row[i][num] = col[j][num] = square[i / 3 * 3 + j / 3][num] = true;
                }
            }

            System.out.println("#" + tc + " " + (isOK ? 1 : 0));
        }
    }
}
