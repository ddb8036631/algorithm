package 너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13459_구슬탈출 {
	static int N, M;
	static int sri, srj, sbi, sbj, ei, ej;
	static char[][] map;
	static boolean[][][][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visit = new boolean[N][M][N][M];
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<M; j++) {
				switch(map[i][j] = s.charAt(j)) {
				case 'R' :
					sri = i; srj = j; break;
				case 'B' :
					sbi = i; sbj = j; break;
				case 'O' :
					ei = i; ej = j; break;
				}
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		visit[sri][srj][sbi][sbj] = true;
		queue.add(new Point(sri, srj, sbi, sbj, 0));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			int ri = now.ri;
			int rj = now.rj;
			int bi = now.bi;
			int bj = now.bj;
			int cnt = now.cnt;
			
			if(cnt > 10)
				break;
			
			if(ri==ei && rj==ej) {
				ans = 1;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int[] nr = move(ri, rj, d);
				int[] nb = move(bi, bj, d);
				
				int nri = nr[0];
				int nrj = nr[1];
				int nbi = nb[0];
				int nbj = nb[1];
				
				if(nbi==ei && nbj==ej) continue;
				
				if(nri==nbi && nrj==nbj) {
					switch(d) {
					case 0:
						if(ri<bi) nbi++;
						else nri++;
						break;
					case 1:
						if(ri<bi) nri--;
						else nbi--;
						break;
					case 2:
						if(rj<bj) nbj++;
						else nrj++;
						break;
					case 3:
						if(rj<bj) nrj--;
						else nbj--;
						break;
					}
				}
				
				if(!visit[nri][nrj][nbi][nbj]) {
					Point next = new Point(nri, nrj, nbi, nbj, cnt+1);
					visit[nri][nrj][nbi][nbj] = true;
					queue.add(next);
				}
			}
		} // end while
		
		System.out.println(ans);
		
	} // end main
	
	static int[] move(int i, int j, int dir) {
		while(true) {
			i += di[dir];
			j += dj[dir];
			
			if(map[i][j] == '#') {
				i -= di[dir];
				j -= dj[dir];
				break;
			} else if(map[i][j] == 'O')
				break;
		}
		return new int[] {i, j};
	}
	
	static class Point {
		int ri, rj, bi, bj, cnt;

		public Point(int ri, int rj, int bi, int bj, int cnt) {
			this.ri = ri;
			this.rj = rj;
			this.bi = bi;
			this.bj = bj;
			this.cnt = cnt;
		}
	}
} // end class
