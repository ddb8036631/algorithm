package SWEA_모의SW역량테스트;

import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_5650_핀볼게임 {
	static int N;
	static int[][] map;
	static List[] wormhole;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			wormhole = new ArrayList[5];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] >= 6) {
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int d=0; d<4; d++) {
						func(i, j, d);
					}
				}
			}
		}
	}
	
	static void func(int si, int sj, int d) {
		int ni = si;
		int nj = sj;
		int cnt = 0;
		
		do {
			ni += di[d];
			nj += dj[d];
			
			if(ni<0 || ni>N-1 || nj<0 || nj>N-1) {
				d = (d + 2) % 2; cnt++; continue;
			}
			
			else if(map[ni][nj] == 1) {
				if(d == 2) d = 1;
				else if(d == 3) d = 0;
				else d = (d + 2) % 2;
				cnt++; continue;
			}
			
			else if(map[ni][nj] == 2) {
				if(d == 0) d = 1;
				else if(d == 3) d = 2;
				else d = (d + 2) % 2;
				cnt++; continue;
			}
			
			else if(map[ni][nj] == 3) {
				if(d == 0) d = 3;
				else if(d == 1) d = 2;
				else d = (d + 2) % 2;
				cnt++; continue;
			}
			
			else if(map[ni][nj] == 4) {
				if(d == 2) d = 3;
				else if(d == 1) d = 0;
				else d = (d + 2) % 2;
				cnt++; continue;
			}
			
			else if(map[ni][nj] == 5) {
				d = (d + 2) % 2; cnt++; continue;
			}
			
			else if(map[ni][nj] == 6) {
				
			}
			
		} while((ni != si && nj != sj) || (map[ni][nj] != -1));
		
		ans = Math.max(ans, cnt);
		
	}
}
