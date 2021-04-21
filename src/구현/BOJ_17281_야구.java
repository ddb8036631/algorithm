package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17281_야구 {
    static int N;
    static int[][] info;
    static int[] order;
    static boolean[] occupied;
    static boolean[] roo = new boolean[4];
    static int answer;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N][9];
        order = new int[9];
        occupied = new boolean[9];

        for (int i = 0; i < N; i++) {
            info[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        order[3] = 0;
        occupied[3] = true;

        perm(1);

        System.out.println(answer);
    }

    static void perm(int idx) {
        if (idx == 9) {
            calc();

            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!occupied[i]) {
                occupied[i] = true;
                order[i] = idx;

                perm(idx + 1);

                occupied[i] = false;
            }
        }
    }

    static void calc() {
        int score = 0;
        int strikerIdx = 0;

        for (int inning = 0; inning < N; inning++) {
            Arrays.fill(roo, false);
            int outCnt = 0;

            while (outCnt < 3) {
                int command = info[inning][order[strikerIdx]];

                switch (command) {
                    case 0:
                        outCnt++;
                        break;
                    case 1:
                        score += move(1);
                        break;
                    case 2:
                        score += move(2);
                        break;
                    case 3:
                        score += move(3);
                        break;
                    case 4:
                        score += move(4);
                        break;
                }

                strikerIdx = (strikerIdx + 1) % 9;
            }
        }

        answer = Math.max(answer, score);
    }

    static int move(int delta) {
        roo[0] = true;
        int hitScore = 0;
        int size = 4;

        while (size-- > 0) {
            if (roo[size]) {
                roo[size] = false;

                if (size + delta >= 4) {
                    hitScore++;
                    continue;
                }

                roo[size + delta] = true;
            }
        }

        return hitScore;
    }
}
