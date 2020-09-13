package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && map[i][j]==1) {
					dfs(i, j, idx++);
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=1; i<idx; i++) {
			for(boolean[] row : visit)
				Arrays.fill(row, false);
			ans = Math.min(ans, bfs(i));
		}
		System.out.println(ans);
	}
	
	static void dfs(int i, int j, int idx) {
		visit[i][j] = true;
		map[i][j] = idx;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
			if(!visit[ni][nj] && map[ni][nj]==1)
				dfs(ni, nj, idx);
		}
	}
	
	static int bfs(int idx) {
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == idx)
					q.add(new Point(i, j));
			}
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point p = q.poll();
				for(int d=0; d<4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					
					if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
					
					if(map[ni][nj] != 0 && map[ni][nj]!=idx) { // 육진데 다른 그룹의 육지면? 거기까지의 cnt를 리턴.
						return cnt;
					} else if(!visit[ni][nj] && map[ni][nj] == 0) { // 바다면? 큐에 다시 넣어서 거기까지의 cnt가 증가되도록 함.
						visit[ni][nj] = true;
						q.add(new Point(ni, nj));
					}
				}
			}
			cnt++;
		}
		return -1;
	}
	
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
