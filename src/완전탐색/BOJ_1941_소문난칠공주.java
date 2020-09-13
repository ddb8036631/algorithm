package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1941_소문난칠공주 {
	static char[][] map = new char[5][5];
	static boolean[][] visit = new boolean[5][5];

	static char[] arr = new char[25];
	static int[] result = new int[7];
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	static int totalCnt;
	static int somCnt;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			String s = sc.next();
			for(int j=0; j<5; j++) {
				arr[i*5+j] = s.charAt(j);
			}
		}
		
		comb(0, 0);
		
		System.out.println(ans);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == 7) {
			for(char[] row : map)
				Arrays.fill(row, '\0');
			for(boolean[] row : visit)
				Arrays.fill(row, false);
			totalCnt = somCnt = 0;
			
			for(int i=0; i<result.length; i++) {
				int r = result[i] / 5;
				int c = result[i] % 5;
				
				map[r][c] = arr[result[i]];
			}
			
			dfs(result[0] / 5, result[0] % 5);
			
			if(totalCnt == 7 && somCnt >= 4)
				ans++;
			
			return;
		}
		
		if(idx == 25)
			return;
		
		result[cnt] = idx;
		
		comb(idx+1, cnt+1);
		comb(idx+1, cnt);
	}
	
	static void dfs(int i, int j) {
		visit[i][j] = true;
		totalCnt++;
		
		if(map[i][j] == 'S')
			somCnt++;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0 || ni>4 || nj<0 || nj>4 || visit[ni][nj] || map[ni][nj] == '\0') continue;
			dfs(ni, nj);
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
