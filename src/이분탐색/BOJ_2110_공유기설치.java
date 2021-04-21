package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2110_공유기설치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] loc = new int[N];

        for (int i = 0; i < N; i++) loc[i] = sc.nextInt();

        Arrays.sort(loc);

        int low = 0;
        int high = (int) 1e9;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int end = loc[0];
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (loc[i] - end >= mid) {
                    cnt++;
                    end = loc[i];
                }
            }

            if (cnt >= C) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
