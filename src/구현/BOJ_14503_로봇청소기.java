package 구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14503_로봇청소기 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				map[i][j] = sc.nextInt();
		
		int ans = 1;
		
		Queue<Point> queue = new LinkedList<>();
		visit[R][C] = true;
		queue.add(new Point(R, C, D));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int i = now.i;
			int j = now.j;
			int dir = now.dir;
			
			int nextDir = dir;
			boolean flag = false;
			
			// 0:상, 1:우, 2:하, 3:좌
			for(int d=0; d<4; d++) {
				nextDir = next(nextDir);
				int ni = i + di[nextDir];
				int nj = j + dj[nextDir];
				
				if(ni>=0 && ni<=N-1 && nj>=0 && nj<=M-1) {
					if(map[ni][nj]== 0 && !visit[ni][nj]) {
						ans++;
						visit[ni][nj] = true;
						queue.add(new Point(ni, nj, nextDir));
						flag = true;
						break;
					}
				}
			}
			
			
			if(!flag) {
				int ni = i - di[dir];
				int nj = j - dj[dir];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>M-1 || map[ni][nj]==1) break;
				
				queue.add(new Point(ni, nj, dir));
			}
		}
		
		System.out.println(ans);
	}
	
	static int next(int dir) {
		if(dir == 0) return 3;
		else if(dir == 1) return 0;
		else if(dir == 2) return 1;
		else return 2;
	}
	
	static class Point {
		int i, j, dir;

		public Point(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}
}
