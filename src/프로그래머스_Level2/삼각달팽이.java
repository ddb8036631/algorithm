package 프로그래머스_Level2;

import java.util.ArrayList;

public class 삼각달팽이 {
    public static ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] map = new int[n + 1][n + 1];
        int[] total = new int[n + 1];
        total[1] = 1;

        for (int idx = 2; idx <= n; idx++)
            total[idx] = total[idx - 1] + idx;

        int cnt = 1, i = 1, j = 1;

        while (cnt <= total[n]) {
            while (i <= n && map[i][j] == 0 && cnt <= total[n]) {
                map[i++][j] = cnt++;
            }
            i--;
            j++;

            while (j <= n && map[i][j] == 0 && cnt <= total[n]) {
                map[i][j++] = cnt++;
            }
            j -= 2;
            i--;

            while (map[i][j] == 0 && cnt <= total[n]) {
                map[i--][j--] = cnt++;
            }
            i += 2;
            j++;
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (map[i][j] != 0)
                    answer.add(map[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(4);
        solution(5);
        solution(6);
    }
}
