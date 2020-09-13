package SWEA_모의SW역량테스트;

import java.util.Scanner;

public class SWEA_4014_활주로건설 {
	static int N, X;
	static int[][] map;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			ans = 0;
			
			N = sc.nextInt();
			X = sc.nextInt();
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			horizontal();
			vertical();
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	public static void horizontal() {
		boolean flag = false;
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				
			}
		}
	}
	
	public static void vertical() {
		
	}
}
