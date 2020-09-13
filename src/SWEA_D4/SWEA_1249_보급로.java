package SWEA_D4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	static int N;
	static int[][] map;
	static int[][] mem;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			mem = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				Arrays.fill(mem[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
				
			});
			
			q.add(new int[] { 0, 0, 0 });
			mem[0][0] = 0;
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ni = temp[0] + di[d];
					int nj = temp[1] + dj[d];

					if (ni < 0 || ni > N - 1 || nj < 0 || nj > N - 1)
						continue;

					int time = temp[2] + map[ni][nj];
					if (mem[ni][nj] > time) {
						mem[ni][nj] = time;
						q.add(new int[] { ni, nj, mem[ni][nj] });
					}
				}
			}

			System.out.println("#" + tc + " " + mem[N - 1][N - 1]);
		}
	}
}
