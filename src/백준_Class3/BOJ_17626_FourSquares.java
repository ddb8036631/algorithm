package 백준_Class3;

import java.util.Scanner;

public class BOJ_17626_FourSquares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N + 1];
		memo[1] = 1;
		int min;

		for (int i = 2; i <= N; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, memo[i - j * j]);

			}
			memo[i] = min + 1;
		}

		System.out.println(memo[N]);
	}
}
