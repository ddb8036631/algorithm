package 백준_Class2;

import java.util.Scanner;

public class BOJ_2805_나무자르기 {
	static int N, M;
	static int[] heights;
	static long answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		heights = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			heights[i] = sc.nextInt();
			max = Math.max(max, heights[i]);
		}

		binarySearch(0, max);
		System.out.println(answer);
	}

	public static void binarySearch(int start, int end) {
		if (start > end)
			return;

		int mid = (start + end) / 2;
		long sum = 0;
		for (int height : heights) {
			if (height > mid) {
				sum += height - mid;
			}
		}

		if (sum >= M) {
			answer = Math.max(answer, mid);
			binarySearch(mid + 1, end);
		} else {
			binarySearch(start, mid - 1);
		}
	}
}
