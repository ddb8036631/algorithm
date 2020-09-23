package 백준_Class2;

import java.util.Scanner;

public class BOJ_1654_랜선자르기 {
	static int K, N;
	static long[] lan;
	static long answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		lan = new long[K];
		long max = 0;
		for (int i = 0; i < K; i++) {
			lan[i] = sc.nextInt();
			max = Math.max(max, lan[i]);
		}

		binarySearch(1, max);
		System.out.println(answer);
	}

	static void binarySearch(long left, long right) {
		if (left > right)
			return;

		long mid = (left + right) / 2;
		long cnt = 0;

		for (long len : lan) {
			cnt += len / mid;
		}

		if (cnt >= N) {
			answer = Math.max(answer, mid);
			binarySearch(mid + 1, right);
		} else {
			binarySearch(left, mid - 1);
		}
	}
}
