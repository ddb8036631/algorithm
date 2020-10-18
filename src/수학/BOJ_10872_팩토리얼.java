package 수학;

import java.util.Scanner;

public class BOJ_10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] facto = new long[N + 1];
		facto[0] = 1;

		for (int i = 1; i <= N; i++) {
			facto[i] = facto[i - 1] * i;
		}

		System.out.println(facto[N]);
	}
}
