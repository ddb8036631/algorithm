package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1194_달이차오른다가자 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static Point start;
	static int ans = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		visit = new boolean[N][M][64];
		
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				if(c == '0')
					start = new Point(i, j, 0, 0);
				map[i][j] = c;
			}
		}
		
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visit[start.i][start.j][0] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			int i = now.i;
			int j = now.j;
			int cnt = now.cnt;
			int key = now.key;
			
			if(map[i][j] == '1') {
				ans = cnt;
				return;
			}
			
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>M-1 || visit[ni][nj][key] || map[ni][nj]=='#') continue;
				
				if(map[ni][nj] == '.' || map[ni][nj] == '0' || map[ni][nj] == '1') {
					visit[ni][nj][key] = true;
					q.add(new Point(ni, nj, cnt + 1, key));
				}
				
				else if(map[ni][nj]>='a' && map[ni][nj]<='f') {
					int newKey = key | (1 << map[ni][nj] - 'a');
					
					visit[ni][nj][newKey] = true;
					q.add(new Point(ni, nj, cnt + 1, newKey));
				}
				
				else if(map[ni][nj]>='A' && map[ni][nj]<='F') {
					if((1 << map[ni][nj] - 'A' & key) != 0) {
						visit[ni][nj][key] = true;
						q.add(new Point(ni, nj, cnt + 1, key));
					}
				}
			}
		}
	}
	
	static class Point {
		int i, j, cnt, key;

		public Point(int i, int j, int cnt, int key) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.key = key;
		}
	}
}
