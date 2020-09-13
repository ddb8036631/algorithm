package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2112_보호필름 {
	static int D, W, K, min;
	static int[][] map, temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1; tc <= TC; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			min = K;
			
			map= new int[D][W];
			temp = new int[D][W];
			
			for(int i = 0; i < D; i++)
				for(int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			
			comb(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void comb(int row, int cnt) {
		if(cnt > min) return;
		
		if(row == D) {
			if(check()) min = Math.min(min, cnt);
			return;
		}
		
		// 약품 투입 안함.
		comb(row + 1, cnt);
		
		// 약품 투입 함.
		for(int val = 0; val < 2; val++) {
			temp[row] = map[row].clone();
			Arrays.fill(map[row], val);
			
			comb(row + 1, cnt + 1);
			
			map[row] = temp[row].clone();
		}
	}
	
	static boolean check() {
		for(int j = 0; j < W; j++) {
			int cnt = 1;
			boolean flag = false;
			for(int i = 0; i < D - 1; i++) {
				if(map[i][j] == map[i+1][j]) cnt++;
				else cnt = 1;
				
				if(cnt >= K) {
					flag = true;
					break;
				}
			}
			if(!flag) return false;
		}
		
		return true;
	}
}
