package dfs;

import java.util.Scanner;

public class SWEA_1949_등산로조성 {
	static int N, K;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			visit = new boolean[N][N];
			
			int maxHeight = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int height = sc.nextInt();
					map[i][j] = height;
					maxHeight = Math.max(maxHeight, height);
				}
			}

			ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == maxHeight) {
						visit[i][j] = true;
						dfs(i, j, 1, false);
						visit[i][j] = false;
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void dfs(int i, int j, int cnt, boolean cut) {
		ans = Math.max(ans, cnt);

		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0 || ni>N-1 || nj<0 || nj>N-1 || visit[ni][nj]) continue;
			
			// 공사 X
			if(map[ni][nj] < map[i][j]) {
				visit[ni][nj] = true;
				dfs(ni, nj, cnt+1, cut);
				visit[ni][nj] = false;
			}
			
			// 공사 O
			else if(!cut && map[ni][nj] >= map[i][j]) {
				for(int k=1; k<=K; k++) {
					cut = true;
					map[ni][nj] -= k;
					
					if(map[ni][nj] < map[i][j]) {
						visit[ni][nj] = true;
						dfs(ni, nj, cnt+1, cut);
						visit[ni][nj] = false;
					}
					
					map[ni][nj] += k;
					cut = false;
				}
			}
		}
	}
}
