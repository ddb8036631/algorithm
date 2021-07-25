package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236_용돈관리 {
    static int N, M;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N];
        int low = 1, high = (int) 1e9, answer = 0;

        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(br.readLine());

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean check(int mid) {
        int remain = mid;
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            if (mid < cost[i]) return false;

            if (remain - cost[i] < 0) {
                remain = mid;
                cnt++;
            }

            remain -= cost[i];
        }

        return cnt <= M;
    }
}