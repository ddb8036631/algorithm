package 분할정복;

import java.util.Scanner;

public class BOJ_1780_종이의개수 {
	static int N;
	static int[][] map;
	static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		answer = new int[3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		solve(N, 0, 0);

		System.out.println(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
	}

	static void solve(int size, int x, int y) {
		int target = map[x][y];
		boolean flag = true;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != target) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			answer[target + 1]++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				solve(size / 3, x + i * size / 3, y + j * size / 3);
			}
		}
	}
}
