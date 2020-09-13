package bruteforce;

import java.util.Scanner;

public class SWEA_7208_지도칠하기 {
	static int N;
	static int[] color;
	static int[][] map;
	static int[] fill;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			color = new int[N];
			map = new int[N][N];
			fill = new int[N];

			for (int i = 0; i < N; i++)
				color[i] = sc.nextInt();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();

			min = Integer.MAX_VALUE;
			perm(0);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void perm(int idx) {
		if (idx == N) {
			if (check()) {
				int count = 0;
				for (int i = 0; i < N; i++) {
					if (color[i] != fill[i])
						count++;
				}

				min = Math.min(min, count);
			}

			return;
		}

		for (int i = 1; i <= 4; i++) {
			fill[idx] = i;
			perm(idx + 1);
		}

	}

	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && fill[i] == fill[j]) {
					return false;
				}
			}
		}
		return true;
	}
}
