package bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15683_감시 {	
	static int N, M;
//	static int[][] map;
	static List<CCTV> list = new ArrayList<>();
	// 상 우 하 좌 
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int ans = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int type = sc.nextInt();
				if(type>=1 && type<=5) {
					list.add(new CCTV(i, j, type));
				}
				map[i][j] = type;
			}
		}
		
		solve(0, map);
		System.out.println("list.size(): " + list.size());
		System.out.println(ans);
	}
	
	static void solve(int idx, int[][] map) {
		if(idx == list.size()) {
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 0)
						cnt++;
				}
			}
			
			ans = Math.min(ans, cnt);
			System.out.println("---map---");
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		CCTV cctv = list.get(idx);
		switch(cctv.type) {
		case 1:
			for(int d=0; d<4; d++) {
				draw(cctv.i, cctv.j, d, map);
				solve(idx+1, map);
				reDraw(cctv.i, cctv.j, d, map);
			}
			break;
		case 2:
			for(int d=0; d<2; d++) {
				draw(cctv.i, cctv.j, d, map);
				draw(cctv.i, cctv.j, d+2, map);
				solve(idx+1, map);
				reDraw(cctv.i, cctv.j, d, map);
				reDraw(cctv.i, cctv.j, d+2, map);
			}
			break;
		case 3:
			for(int d=0; d<4; d++) {
				draw(cctv.i, cctv.j, d, map);
				draw(cctv.i, cctv.j, (d+1)%4, map);
				solve(idx+1, map);
				reDraw(cctv.i, cctv.j, d, map);
				reDraw(cctv.i, cctv.j, (d+1)%4, map);
			}
			break;
		case 4:
			for(int d=0; d<4; d++) {
				draw(cctv.i, cctv.j, d, map);
				draw(cctv.i, cctv.j, (d+1)%4, map);
				draw(cctv.i, cctv.j, (d+2)%4, map);
				solve(idx+1, map);
				reDraw(cctv.i, cctv.j, d, map);
				reDraw(cctv.i, cctv.j, (d+1)%4, map);
				reDraw(cctv.i, cctv.j, (d+2)%4, map);
			}
			break;
		case 5:
			draw(cctv.i, cctv.j, 0, map);
			draw(cctv.i, cctv.j, 1, map);
			draw(cctv.i, cctv.j, 2, map);
			draw(cctv.i, cctv.j, 3, map);
			solve(idx+1, map);
			reDraw(cctv.i, cctv.j, 0, map);
			reDraw(cctv.i, cctv.j, 1, map);
			reDraw(cctv.i, cctv.j, 2, map);
			reDraw(cctv.i, cctv.j, 3, map);
			break;
		}
	}
	
	static void draw(int i, int j, int d, int[][] map) {
		int ni = i;
		int nj = j;
		
		while(true) {
			ni += di[d];
			nj += dj[d];
			
			if(ni<0 || ni>N-1 || nj<0 || nj>M-1 || map[ni][nj]==6) break;
			if(map[ni][nj] == 0)
				map[ni][nj] = -1;
		}
	}
	
	static void reDraw(int i, int j, int d, int[][] map) {
		int ni = i;
		int nj = j;
		
		while(true) {
			ni += di[d];
			nj += dj[d];
			
			if(ni<0 || ni>N-1 || nj<0 || nj>M-1 || map[ni][nj]==6) break;
			if(map[ni][nj] == -1)
				map[ni][nj] = 0;
		}
	}
	
	static class CCTV {
		int i, j, type;

		public CCTV(int i, int j, int type) {
			this.i = i;
			this.j = j;
			this.type = type;
		}
	}
}
