package 구현;

import java.util.Scanner;

public class BOJ_14500_테트로미노 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int answer = Integer.MIN_VALUE;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				dfs(y, x, 1, map[y][x]);
				checkExtra(y, x);
			}
		}

		System.out.println(answer);
	}

	static void dfs(int y, int x, int cnt, int sum) {
		if (cnt == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + di[d];
			int nx = x + dj[d];

			if (ny < 0 || ny > N - 1 || nx < 0 || nx > M - 1 || visit[ny][nx])
				continue;

			dfs(ny, nx, cnt + 1, sum + map[ny][nx]);
		}

		visit[y][x] = false;
	}

	static void checkExtra(int y, int x) {
		int sum = 0;

		// 1. ㅗ shape
		if (y - 1 >= 0 && x + 1 <= M - 1 && x + 2 <= M - 1) {
			sum = map[y][x] + map[y - 1][x + 1] + map[y][x + 1] + map[y][x + 2];
			answer = Math.max(answer, sum);
			sum = 0;
		}

		// 2. ㅏ shape
		if (y + 1 <= N - 1 && y + 2 <= N - 1 && x + 1 <= M - 1) {
			sum = map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x];
			answer = Math.max(answer, sum);
			sum = 0;
		}

		// 3. ㅜ shape
		if (x + 1 <= M - 1 && x + 2 <= M - 1 && y + 1 <= N - 1) {
			sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1];
			answer = Math.max(answer, sum);
			sum = 0;
		}

		// 4. ㅓ shape
		if (y + 1 <= N - 1 && y + 2 <= N - 1 && x - 1 >= 0) {
			sum = map[y][x] + map[y + 1][x - 1] + map[y + 1][x] + map[y + 2][x];
			answer = Math.max(answer, sum);
			sum = 0;
		}
	}
}
