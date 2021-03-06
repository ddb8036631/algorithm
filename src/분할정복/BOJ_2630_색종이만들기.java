package 분할정복;

import java.util.Scanner;

public class BOJ_2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int white, blue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		solve(N, 0, 0);

		System.out.println(white);
		System.out.println(blue);
	}

	static void solve(int size, int x, int y) {
		int sum = 0;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				sum += map[i][j];
			}
		}

		if (sum == 0)
			white++;
		else if (sum == size * size)
			blue++;
		else {
			solve(size / 2, x, y);
			solve(size / 2, x, y + size / 2);
			solve(size / 2, x + size / 2, y);
			solve(size / 2, x + size / 2, y + size / 2);

			return;
		}
	}
}
