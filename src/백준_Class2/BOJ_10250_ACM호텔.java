package 백준_Class2;

import java.util.Scanner;

public class BOJ_10250_ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			int q = N / H; // 호
			int r = N % H; // 층

			if (r == 0) {
				System.out.printf("%d%02d\n", H, q);
			} else {
				System.out.printf("%d%02d\n", r, q + 1);
			}
		}
	}
}
