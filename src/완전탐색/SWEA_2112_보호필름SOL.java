package bruteforce;

import java.util.Scanner;

public class SWEA_2112_보호필름SOL {
	static int D, W, K, min;
	static int[][] map;
	static int[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1; tc <= TC; tc++) {
			min = Integer.MAX_VALUE;
			
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			map = new int[D][W];
			list = new int[D];
			
			for(int i = 0; i < D; i++)
				for(int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			
			dfs(0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void dfs(int row, int count) {
		if(row == D) {
			if(check()) {
				min = Math.min(min, count);
			}
			return;
		}
		
		if(count >= min) {
			return;
		}
		
		list[row] = 0;
		dfs(row + 1, count);
		
		list[row] = 1;
		dfs(row + 1, count + 1);
		
		list[row] = 2;
		dfs(row + 1, count + 1);
	}
	
	static boolean check() {
		int count;
		int cur, next;
		
		for(int i = 0; i < W; i++) {
			count = 1;
			for(int j = 0; j < D - 1; j++) {
				cur = map[j][i];
				next = map[j + 1][i];
				
				if(list[j] > 0) {
					cur = list[j] - 1;
				}
				if(list[j + 1] > 0) {
					next = list[j + 1] - 1;
				}
				
				if(cur == next) {
					count++;
					if(count >= K) break;
				} else
					count = 1;
			}
			
			if(count < K) return false;
		}
		return true;
	}
}
