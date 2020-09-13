package 깊이우선탐색;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2468_안전영역 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int height=0; height<=100; height++) {
			for(boolean[] row : visit)
				Arrays.fill(row, false);
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j] && map[i][j]>height) {
						cnt++;
						dfs(i, j, height);
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	
	static void dfs(int i, int j, int height) {
		visit[i][j] = true;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0 || ni>N-1 || nj<0 || nj>N-1 || visit[ni][nj] || map[ni][nj]<=height) continue;
			dfs(ni, nj, height);
		}
	}
}
