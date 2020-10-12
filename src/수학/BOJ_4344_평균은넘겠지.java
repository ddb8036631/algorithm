package 수학;

import java.util.Scanner;

public class BOJ_4344_평균은넘겠지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[] scores = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				sum += scores[i];
			}

			double avg = (double) sum / N;

			int cnt = 0;
			for (int score : scores) {
				if (score > avg)
					cnt++;
			}

			double answer = (double) cnt / N * 100;
			System.out.println(String.format("%.3f%%", answer));
		}
	}
}
