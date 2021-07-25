package SWEA_D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1215_회문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = 8;

        for (int tc = 1; tc <= 10; tc++) {
            int N = stoi(br.readLine());
            char[][] map = new char[SIZE][SIZE];
            int cnt = 0;

            for (int i = 0; i < SIZE; i++) map[i] = br.readLine().toCharArray();

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    StringBuilder sb = new StringBuilder();

                    if (j + N <= SIZE) {
                        for (int y = j; y < j + N; y++) sb.append(map[i][y]);
                        if (check(sb.toString().toCharArray())) cnt++;
                    }

                    sb = new StringBuilder();

                    if (i + N <= SIZE) {
                        for (int x = i; x < i + N; x++) sb.append(map[x][j]);
                        if (check(sb.toString().toCharArray())) cnt++;
                    }
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean check(char[] s) {
        int left = s.length / 2 - 1, right = s.length % 2 == 0 ? s.length / 2 : s.length / 2 + 1;

        while (left >= 0 && right <= s.length - 1) {
            if (s[left] != s[right]) return false;

            left--;
            right++;
        }

        return true;
    }
}

