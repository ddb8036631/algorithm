package 분할정복;

import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] map;
	static StringBuffer answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		answer = new StringBuffer();
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++)
				map[i][j] = s.charAt(j) - '0';

		}
		solve(N, 0, 0);
		System.out.println(answer);
	}

	static void solve(int size, int x, int y) {
		int sum = 0;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0) {
			answer.append(0);
		} else if (sum == size * size) {
			answer.append(1);
		} else {
			answer.append('(');
			solve(size / 2, x, y);
			solve(size / 2, x, y + size / 2);
			solve(size / 2, x + size / 2, y);
			solve(size / 2, x + size / 2, y + size / 2);
			answer.append(')');
		}
	}
}
