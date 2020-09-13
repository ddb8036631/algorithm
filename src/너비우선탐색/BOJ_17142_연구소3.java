package 너비우선탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17142_연구소3 {
	static int N; // 연구소의 크기 
	static int M; // 놓을 수 있는 바이러스의 개수
	static int[][] map;
	static int[][] tempMap;
	static boolean[][] visit;
	static List<Virus> virusList = new ArrayList<>();
	static List<Virus> activeVirusList = new ArrayList<>();
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int min;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		tempMap = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int num = sc.nextInt();
				if(num == 2) {
					virusList.add(new Virus(i, j, false));
				}
				map[i][j] = num;
			}
		}
		
		comb(0, 0);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans - 1);
	}

	static void comb(int idx, int cnt) {
		if(cnt == M) {
			for(boolean[] row : visit)
				Arrays.fill(row, false);
			for(int[] row : tempMap)
				Arrays.fill(row, 0);
			
			bfs();
			
			min = 0;
			if(check()) {
				ans = Math.min(ans, min);
			}
			
//			for(Virus v : activeVirusList)
//				System.out.println(v);
//			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(tempMap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			return;
		}
		
		if(idx == virusList.size())
			return;
		
		virusList.get(idx).isActive = true;
		activeVirusList.add(virusList.get(idx));
		comb(idx+1, cnt+1);
		
		virusList.get(idx).isActive = false;
		activeVirusList.remove(virusList.get(idx));
		comb(idx+1, cnt);
		
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		for(Virus virus : activeVirusList) {
			visit[virus.i][virus.j] = true;
			q.add(new Point(virus.i, virus.j, 0));
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point now = q.poll();

				for(int d=0; d<4; d++) {
					int ni = now.i + di[d];
					int nj = now.j + dj[d];
					
					if(ni<0 || ni>N-1 || nj<0 || nj>N-1 || visit[ni][nj]) continue;
					if(map[ni][nj] == 1) {
						tempMap[ni][nj] = -1;
						continue;
					}
					
					tempMap[ni][nj] = now.cnt + 1;
					visit[ni][nj] = true;
					q.add(new Point(ni, nj, now.cnt+1));
				}
			}
		}
	}
	
	static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tempMap[i][j] == 0 && map[i][j] == 0)
					return false;
				min = Math.max(min, tempMap[i][j]);
			}
		}
		return true;
	}
	
	static class Virus {
		int i, j;
		boolean isActive;
		
		public Virus(int i, int j, boolean isActive) {
			this.i = i;
			this.j = j;
			this.isActive = isActive;
		}

		@Override
		public String toString() {
			return "Virus [i=" + i + ", j=" + j + ", isActive=" + isActive + "]";
		}
	}
	
	static class Point {
		int i, j, cnt;

		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}
