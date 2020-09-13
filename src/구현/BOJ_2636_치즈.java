package 구현;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2636_치즈 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static final int CHEESE = 1;
	static final int EDGE = 2;
	static final int AIR = 3;
	static int time;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while(!isFinished()) {
			time++;
			cnt = 0;
			countCheese();
			initVisit();
			findAir(0, 0);
			initVisit();
			findEdge(0, 0);
			removeEdge();
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	static boolean isFinished() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == CHEESE)
					return false;
			}
		}
		return true;
	}
	
	static void countCheese() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == CHEESE)
					cnt++;
			}
		}
	}
	
	static void initVisit() {
		for(boolean[] row : visit)
			Arrays.fill(row, false);
	}
	
	static void findAir(int i, int j) {
		visit[i][j] = true;
		map[i][j] = AIR;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni<0 || ni>N-1 || nj<0 || nj>M-1 || visit[ni][nj] || (map[ni][nj]!=0 && map[ni][nj]!=AIR)) continue;
			
			findAir(ni, nj);
		}
	}
	
	static void findEdge(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		visit[i][j] = true;
		q.add(new Point(i, j));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int d=0; d<4; d++) {
				int ni = now.x + di[d];
				int nj = now.y + dj[d];
				if(ni<0 || ni>N-1 || nj<0 || nj>M-1 || visit[ni][nj]) continue;
				
				if(map[ni][nj] == AIR) {
					visit[ni][nj] = true;
					q.add(new Point(ni, nj));
				}
				if(map[now.x][now.y] == AIR && map[ni][nj] == CHEESE) {
					map[ni][nj] = EDGE;
					visit[ni][nj] = true;
					q.add(new Point(ni, nj));
				}
			}
		}
	}
	
	static void removeEdge() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == EDGE)
					map[i][j] = AIR;
			}
		}
	}
}
