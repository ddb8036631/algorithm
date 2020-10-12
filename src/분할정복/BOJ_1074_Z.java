package 분할정복;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int N, r, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		solve();
	}

	static void solve() {
		int x = (int) Math.pow(2, N) / 2;
		int y = x;
		int answer = 0;

		while (N-- > 0) {
			int tmp = (int) Math.pow(2, N) / 2;
			int skip = (int) Math.pow(4, N);

			if (c < x && r < y) {
				y -= tmp;
				x -= tmp;
			} else if (c >= x && r < y) {
				y -= tmp;
				x += tmp;
				answer += skip;
			} else if (c < x && r >= y) {
				y += tmp;
				x -= tmp;
				answer += skip * 2;
			} else {
				y += tmp;
				x += tmp;
				answer += skip * 3;
			}
		}

		System.out.println(answer);
	}
}
