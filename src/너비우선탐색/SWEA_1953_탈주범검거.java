package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_탈주범검거 {
	static int N, M, R, C, L;

	static int[][] map;
	static boolean[][] visit;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	static int[][] hole = {
			{0},
			{1, 1, 1, 1}, // 1
			{1, 0, 1, 0}, // 2
			{0, 1, 0, 1}, // 3
			{1, 1, 0, 0}, // 4
			{0, 1, 1, 0}, // 5
			{0, 0, 1, 1}, // 6
			{1, 0, 0, 1} // 7
	};
	
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			ans = 0;
			bfs();
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		visit[R][C] = true;
		queue.add(new Point(R, C));
		
		int time = 1;
		while(!queue.isEmpty()) {
			if(time == L)
				break;
			
			int size = queue.size();
			for(int s=0; s<size; s++) {
				Point now = queue.poll();
				
				for(int d=0; d<4; d++) {
					if(hole[map[now.i][now.j]][d] == 1) {
						int ni = now.i + di[d];
						int nj = now.j + dj[d];
						
						if(ni<0 || ni>N-1 || nj<0 || nj>M-1 || visit[ni][nj] || map[ni][nj] == 0) continue;
						
						if(hole[map[ni][nj]][(d+2)%4] == 1) {
							visit[ni][nj] = true;
							queue.add(new Point(ni, nj));
						}
					}
				}
			}
			time++;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]) {
					ans++;
				}
			}
		}
	}
	
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
