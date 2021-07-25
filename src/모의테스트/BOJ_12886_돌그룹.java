package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12886_돌그룹 {
    static int[] stones;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stones = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visit = new boolean[1501][1501];
        int sum = 0;
        for (int cnt : stones) sum += cnt;

        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        visit[stones[0]][stones[1]] = true;
        q.add(new int[]{stones[0], stones[1], stones[2]});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (now[i] < now[j]) {
                        int nx = now[i] + now[i];
                        int ny = now[j] - now[i];

                        if (visit[nx][ny]) continue;

                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny, sum - nx - ny});
                    }
                }
            }
        }

        System.out.println(visit[sum / 3][sum / 3] ? 1 : 0);
    }
}
