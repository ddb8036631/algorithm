package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4013_특이한자석 {
	static int K;
	static int[][] magnet = new int[4][8];
	static int[] dirs = new int[4];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc = 1; tc <= TC; tc++) {
			K = sc.nextInt();
			for(int i = 0; i < 4; i++)
				Arrays.fill(magnet[i], 0);
			
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 8; j++)
					magnet[i][j] = sc.nextInt();
			
			for(int i = 0; i < K; i++) {
				int idx = sc.nextInt();
				int dir = sc.nextInt();
				
				check(idx - 1, dir);
			}
			
			int sum = 0;
			sum = magnet[0][0] + magnet[1][0] * 2 + magnet[2][0] * 4 + magnet[3][0] * 8;
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	
	static void check(int idx, int dir) {
		Arrays.fill(dirs, 0);
		dirs[idx] = dir;
		
		for(int now = idx; now <= 2; now++) {
			if(magnet[now][2] != magnet[now+1][6]) dirs[now + 1] = dirs[now] * -1;
			else break;
		}
		
		for(int now = idx; now >= 1; now--) {
			if(magnet[now][6] != magnet[now - 1][2]) dirs[now - 1] = dirs[now] * -1;
			else break;
		}
		
		rotate();
	}
	
	static void rotate() {
		for(int idx = 0; idx < dirs.length; idx++) {
			if(dirs[idx] == 1) {
				int temp = magnet[idx][7];
				
				for(int i = 6; i>=0; i--) {
					magnet[idx][i+1] = magnet[idx][i];
				}
				magnet[idx][0] = temp;
			} else if(dirs[idx] == -1) {
				int temp = magnet[idx][0];
				
				for(int i = 1; i < 8; i++) {
					magnet[idx][i - 1] = magnet[idx][i];
				}
				magnet[idx][7] = temp;
			}
		}
	}
}
