package 이분탐색;

import java.util.Scanner;

public class BOJ_13702_이상한술집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        int low = 0, high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            for (int num : arr) cnt += num / mid;

            if (cnt >= K) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(high);
    }
}
