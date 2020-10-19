package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16401_과자나눠주기 {
	static int M, N;
	static int[] snack;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		snack = new int[N];

		for (int i = 0; i < N; i++)
			snack[i] = sc.nextInt();
		Arrays.sort(snack);

		int low = 1;
		int high = snack[N - 1];

		while (low <= high) {
			int mid = (low + high) / 2;
			int cnt = 0;

			for (int s : snack) {
				cnt += s / mid;
			}

			if (cnt >= M) {
				answer = Math.max(answer, mid);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(answer);
	}

}
