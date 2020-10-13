package 분할정복;

import java.util.Scanner;

public class BOJ_2630_색종이만들기 {
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int white = 0;
		int blue = 0;
		solve(N, N/2, N/2, white, blue);
	}
	
	static void solve(int N, int y, int x, int white, int blue) {
		for(int i = x - N / 2; )
	}
}
