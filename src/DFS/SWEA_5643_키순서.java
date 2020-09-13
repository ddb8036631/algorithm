package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5643_키순서 {
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static int cnt;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N+1][N+1];
			visit = new boolean[N+1];
			
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
			}
			
			for(int i=1; i<=N; i++) {
				cnt = 0;
	
//				Arrays.fill(visit, false);
//				dfsUp(i);
				
				Arrays.fill(visit, false);
				dfsDown(i);
				
				System.out.println(cnt);
				
				if(cnt == N-1)
					ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void dfsUp(int idx) {
		visit[idx] = true;
		
		for(int i=1; i<=N; i++) {
			if(!visit[i] && map[idx][i] == 1) {
				cnt++;
				dfsUp(i);
			}
		}
	}
	
	static void dfsDown(int idx) {
		visit[idx] = true;
		
		for(int i=1; i<=N; i++) {
			if(!visit[i] && map[i][idx] == 1) {
				cnt++;
				dfsDown(i);
			}
		}
	}
}
