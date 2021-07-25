package SWEA_D3;

import java.util.Scanner;

public class SWEA_1216_회문2 {
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            char[][] map = new char[100][100];
            answer = 0;

            for (int i = 0; i < 100; i++) {
                map[i] = sc.next().toCharArray();
            }

            for (int i1 = 0; i1 < 100; i1++) {
                for (int j1 = 0; j1 < 100; j1++) {
                    StringBuilder sb = new StringBuilder();

                    for (int i2 = i1; i2 < 100; i2++) {
                        sb.append(map[i2][j1]);
                        check(sb.toString());
                    }

                    sb = new StringBuilder();

                    for (int j2 = j1; j2 < 100; j2++) {
                        sb.append(map[i1][j2]);
                        check(sb.toString());
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void check(String s) {
        int left = s.length() / 2 - 1, right = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) return;
            left--;
            right++;
        }

        answer = Math.max(answer, s.length());
    }
}
