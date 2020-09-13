package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양 {
	static int[][] map;
	static ArrayList<Point> inactive;
	static PriorityQueue<Point> active;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			inactive = new ArrayList<Point>();
			active = new PriorityQueue<Point>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N+2*K][M+2*K];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if(life != 0) {
						int x = i + K;
						int y = j + K;
						
						map[x][y] = life;
						inactive.add(new Point(x, y, life, 0));
					}
				}
			} // 입력.
			
			for(int time=1; time<=K; time++) {
				for(int i=0; i<inactive.size(); i++) {
					Point cell = inactive.get(i);
					cell.now++;
					if(cell.life < cell.now) {
						active.add(cell);
					}
				}
				
				while(!active.isEmpty()) {
					Point cell = active.poll();
					
					for(int d=0; d<4; d++) {
						int ni = cell.i + di[d];
						int nj = cell.j + dj[d];
						
						if(map[ni][nj] == 0) {
							inactive.add(new Point(ni, nj, cell.life, 0));
							map[ni][nj] = cell.life;
						}
					}
				}
				
				for(int i=0; i<inactive.size(); i++) {
					Point cell = inactive.get(i);
					if(cell.life*2 == cell.now) {
						inactive.remove(i);
						map[cell.i][cell.j] = -1;
						i--;
					}
				}
			}
			
			int cnt = 0;
			for(int[] arr : map) {
				for(int a : arr) {
					if(a==0 || a==-1) continue;
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
	
	static class Point implements Comparable<Point> {
		int i;
		int j;
		int life;
		int now;
		
		public Point(int i, int j, int life, int now) {
			this.i = i;
			this.j = j;
			this.life = life;
			this.now = now;
		}

		@Override
		public int compareTo(Point o) {
			return o.life-this.life;
		}
	}
}
