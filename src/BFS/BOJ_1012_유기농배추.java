package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	static int M, N;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			map = new int[M][N];
			visit = new boolean[M][N];
			for(int i=0; i<K; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			int ans = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j] && map[i][j]==1) {
						ans++;
						bfs(i, j);
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	static void bfs(int i, int j) {
		visit[i][j] = true;
		queue.add(new Point(i, j));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int d=0; d<4; d++) {
				int ni = now.x + di[d];
				int nj = now.y + dj[d];
				
				if(ni<0 || ni>M-1 || nj<0 || nj>N-1 || visit[ni][nj] || map[ni][nj]==0) continue;
				visit[ni][nj] = true;
				queue.add(new Point(ni, nj));
			}
		}
	}
}
