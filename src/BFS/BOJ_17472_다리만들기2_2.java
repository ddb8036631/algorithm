package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2_2 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
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
		
		graph = new int[idx][idx];
		for(int[] row : graph)
			Arrays.fill(row, Integer.MAX_VALUE);
		for(int i=1; i<idx; i++) {
			for(boolean[] row : visit)
				Arrays.fill(row, false);
			makeGraph(i);
		}
		
		for(int i=0; i<idx; i++) {
			for(int j=0; j<idx; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int i, int j, int idx) {
		visit[i][j] = true;
		map[i][j] = idx;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0 || ni>N-1 || nj<0 || nj>M-1) continue;
			if(!visit[ni][nj] && map[ni][nj]==1)
				dfs(ni, nj, idx);
		}
	}
	
	static void makeGraph(int idx) {
		Queue<Point> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == idx) {
					visit[i][j] = true;
					q.add(new Point(i, j));
				}
			}
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point p = q.poll();
				
				for(int d=0; d<4; d++) {
					int ni = p.x + di[d];
					int nj = p.y + dj[d];
					
					if(ni<0 || ni>N-1 || nj<0 || nj>M-1) continue;
					if(map[ni][nj]!=0 && map[ni][nj]!=idx && cnt>=2) {
						graph[idx][map[ni][nj]] = graph[map[ni][nj]][idx] = Math.min(graph[idx][map[ni][nj]], cnt);
					} else if(!visit[ni][nj] && map[ni][nj]==0) {
						visit[ni][nj] = true;
						q.add(new Point(ni, nj));
					}
				}
			}
			cnt++;
		}
	}
}
