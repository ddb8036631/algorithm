package 구현;

import java.util.Scanner;

public class BOJ_14499_주사위굴리기 {
	static int N, M;
	static int[][] map;
	static int x, y;
	static int K;
	static int[] command;
	static int[] dice = new int[6];

	// 1: 동, 2: 서, 3: 북, 4: 남
	static int[] di = { 0, 0, 0, -1, 1 };
	static int[] dj = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		command = new int[K];
		for (int i = 0; i < K; i++)
			command[i] = sc.nextInt();

		for (int i = 0; i < K; i++) {
			int ni = x + di[command[i]];
			int nj = y + dj[command[i]];

			switch (command[i]) {
			case 1:
				if (isRange(ni, nj)) {
					int tmp = dice[1];
					dice[1] = dice[2];
					dice[2] = dice[3];
					dice[3] = dice[5];
					dice[5] = tmp;

					copy(ni, nj);

					x = ni;
					y = nj;
				}
				break;
			case 2:
				if (isRange(ni, nj)) {
					int tmp = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[3];
					dice[3] = dice[2];
					dice[2] = tmp;

					copy(ni, nj);

					x = ni;
					y = nj;
				}
				break;
			case 3:
				if (isRange(ni, nj)) {
					int tmp = dice[0];
					dice[0] = dice[5];
					dice[5] = dice[4];
					dice[4] = dice[2];
					dice[2] = tmp;

					copy(ni, nj);

					x = ni;
					y = nj;
				}
				break;
			case 4:
				if (isRange(ni, nj)) {
					int tmp = dice[0];
					dice[0] = dice[2];
					dice[2] = dice[4];
					dice[4] = dice[5];
					dice[5] = tmp;

					copy(ni, nj);

					x = ni;
					y = nj;
				}
				break;
			}
		}
	}

	public static boolean isRange(int i, int j) {
		if (i >= 0 && i <= N - 1 && j >= 0 && j <= M - 1)
			return true;
		return false;
	}

	public static void copy(int i, int j) {
		if (map[i][j] == 0) {
			map[i][j] = dice[2];
		} else {
			dice[2] = map[i][j];
			map[i][j] = 0;
		}

		System.out.println(dice[5]);
	}
}
