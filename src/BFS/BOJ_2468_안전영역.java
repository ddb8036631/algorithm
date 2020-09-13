package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2468_안전영역 {
	static int N;
	static int[][] a;
	static int[][] b;
	static int[][] c;
	static int[] h;

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	static void makeSafetyArea(int height) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (a[i][j] > height) {
					b[i][j] = 1;
				} else
					b[i][j] = 0;
			}
		}
	}

	static int bfs() {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (b[i][j] == 1) {
					cnt += 1;

					b[i][j] = 0;

					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));

					while (!q.isEmpty()) {
						Point p = q.poll();
						int x = p.x;
						int y = p.y;
						c[x][y] = cnt;
						
						for (int d = 0; d < 4; d++) {
							int ni = x + di[d];
							int nj = y + dj[d];

							if (ni >= 0 && ni <= N - 1 && nj >= 0 && nj <= N - 1 && b[ni][nj] == 1) {
								b[ni][nj] = 0;
								q.add(new Point(ni, nj));
								c[ni][nj] = cnt;
							}
						}
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][N];
		b = new int[N][N];
		c = new int[N][N];
		h = new int[101];
		
		int max = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = sc.nextInt();
				a[i][j] = n;
				h[n]++;
			}
		}

		for (int l = 1; l <= 100; l++) {
			if (h[l] > 0) {
				makeSafetyArea(l);
				int cnt = bfs();
				if(max < cnt)
					max = cnt;
			}
		}
		
		System.out.println(max);
	}
}