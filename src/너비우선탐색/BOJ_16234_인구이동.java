package 너비우선탐색;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16234_인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Point> queue = new LinkedList<>();
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static List<Point> list = new ArrayList<>();
	
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				map[i][j] = sc.nextInt();
		
		while(true) {
			if(canExit()) break;
			for(int i=0; i<N; i++)
				Arrays.fill(visit[i], false);
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			ans++;
//			printMap();
		}
		
		System.out.println(ans);
	}
	
	static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean canExit() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int d=0; d<4; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
					int diff=Math.abs(map[ni][nj] - map[i][j]);
					if(L<=diff && diff<=R) return false;
				}
			}
		}
		return true;
	}
	
	static void bfs(int si, int sj) {
		int sum = 0;
		
		visit[si][sj] = true;
		queue.add(new Point(si, sj));

		while(!queue.isEmpty()) {
			Point now = queue.poll();
			list.add(new Point(now.x, now.y));
			sum += map[now.x][now.y];
			
			for(int d=0; d<4; d++) {
				int ni = now.x+di[d];
				int nj = now.y+dj[d];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>N-1 || visit[ni][nj]) continue;
				
				int diff = Math.abs(map[ni][nj] - map[now.x][now.y]);
				if(L<=diff && diff<=R) {
					visit[ni][nj] = true;
					queue.add(new Point(ni, nj));
				}
			}
		}
		
		int temp = sum/list.size();
//		System.out.println("temp : " + temp);

		for(Point p : list) {
			map[p.x][p.y] = temp;
		}
		
		list.clear();
	}
}
