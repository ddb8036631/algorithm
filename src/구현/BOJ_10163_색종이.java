package 구현;

import java.util.Scanner;

public class BOJ_10163_색종이 {
	static int N;
	static int[][] map;
	static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[110][110];
		count = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			solve(x, y, w, h, n);
		}

		for (int i = 0; i < 110; i++) {
			for (int j = 0; j < 110; j++) {
				count[map[i][j]]++;
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.println(count[i]);
	}

	static void solve(int x, int y, int w, int h, int num) {
		for (int i = x; i < x + w; i++) {
			for (int j = y; j < y + h; j++) {
				map[i][j] = num;
			}
		}
	}
}
