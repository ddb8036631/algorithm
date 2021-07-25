package 모의테스트;

import java.util.Scanner;

public class BOJ_15658_연산자끼워넣기2 {
    static int N;
    static int[] arr;
    static int[] opCnt = new int[4];
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) opCnt[i] = sc.nextInt();

        dfs(1, arr[0], opCnt);

        System.out.println(max + "\n" + min);
    }

    static void dfs(int idx, int sum, int[] opCnt) {
        if (idx == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        int[] tmp = opCnt.clone();

        if (tmp[0] > 0) {
            tmp[0]--;
            dfs(idx + 1, sum + arr[idx], tmp);
            tmp[0]++;
        }
        if (tmp[1] > 0) {
            tmp[1]--;
            dfs(idx + 1, sum - arr[idx], tmp);
            tmp[1]++;
        }
        if (tmp[2] > 0) {
            tmp[2]--;
            dfs(idx + 1, sum * arr[idx], tmp);
            tmp[2]++;
        }
        if (tmp[3] > 0) {
            tmp[3]--;
            dfs(idx + 1, sum / arr[idx], tmp);
            tmp[3]++;
        }
    }
}
