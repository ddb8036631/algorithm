package 완전탐색;

import java.util.Scanner;

public class BOJ_2503_숫자야구 {
    static int N;
    static Info[] infos;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        infos = new Info[N];
        used = new boolean[10];
        int cnt = 0;

        for (int i = 0; i < N; i++)
            infos[i] = new Info(String.valueOf(sc.nextInt()).toCharArray(), sc.nextInt(), sc.nextInt());

        for (int i = 1; i <= 9; i++) {
            used[i] = true;

            for (int j = 1; j <= 9; j++) {
                if (j == i) continue;

                used[j] = true;

                for (int k = 1; k <= 9; k++) {
                    if (k == j || k == i) continue;

                    used[k] = true;
                    if (check(i, j, k)) cnt++;
                    used[k] = false;
                }

                used[j] = false;
            }

            used[i] = false;
        }

        System.out.println(cnt);
    }

    static boolean check(int x, int y, int z) {
        char[] now = (x + "" + y + z).toCharArray();

        for (int i = 0; i < N; i++) {
            int sc = 0, bc = 0;

            for (int j = 0; j < 3; j++) {
                if (now[j] == infos[i].question[j]) sc++;
                else if (used[infos[i].question[j] - '0']) bc++;
            }

            if (sc != infos[i].strikeCnt || bc != infos[i].ballCnt) return false;
        }

        return true;
    }

    static class Info {
        char[] question;
        int strikeCnt;
        int ballCnt;

        public Info(char[] question, int strikeCnt, int ballCnt) {
            this.question = question;
            this.strikeCnt = strikeCnt;
            this.ballCnt = ballCnt;
        }
    }
}
