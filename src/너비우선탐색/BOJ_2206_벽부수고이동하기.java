package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static boolean[][][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int ans = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1][2];
		for(int i=1; i<=N; i++) {
			String s = sc.next();
			for(int j=1; j<=M; j++) {
				map[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visit[1][1][0] = true;
		q.add(new Point(1, 1, 1, 0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int i = now.i;
			int j = now.j;
			int cnt = now.cnt;
			int wallbreak = now.wallbreak;

			if(i == N && j == M) {
				ans = cnt;
				return;
			}
			
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				
				if(ni<1 || ni>N || nj<1 || nj>M) continue;

				if(map[ni][nj] == 0) { // 빈칸일때
					if(!visit[ni][nj][wallbreak]) {
						visit[ni][nj][wallbreak] = true;
						q.add(new Point(ni, nj, cnt + 1, wallbreak));
					}
				} else if(map[ni][nj] == 1) { // 벽일때
					if(wallbreak == 0 && !visit[ni][nj][1]) {
						visit[ni][nj][1] = true;
						q.add(new Point(ni, nj, cnt + 1, 1));
					}
				}
			}
		}
	}
	
	static class Point {
		int i, j, cnt, wallbreak;

		public Point(int i, int j, int cnt, int wallbreak) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.wallbreak = wallbreak;
		}
	}
}
