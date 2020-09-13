package 완전탐색;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	static ArrayList<Point> houses = new ArrayList<>();
	static ArrayList<Chicken> chickens = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		dist = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int num = sc.nextInt();
				if(num == 1)
					houses.add(new Point(i, j));
				if(num == 2) {
					chickens.add(new Chicken(i, j, false));
				}
			}
		}
		
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == M) {
			calc();
			return;
		}
		
		if(idx > chickens.size()-1) return;
		
		for(int i=idx; i<chickens.size();i++) {
			if(!chickens.get(i).used) {
				chickens.get(i).used = true;
				comb(idx+1, cnt + 1);
				chickens.get(i).used = false;
			}
		}
	}
	
	static void calc() {
		for(int[] arr : dist)
			Arrays.fill(arr, 0);
		
		for(int i=0; i<houses.size(); i++) {
			Point house = houses.get(i);
			int x1 = house.x;
			int y1 = house.y;
			
			int min = Integer.MAX_VALUE;
			
			for(int j=0; j<chickens.size(); j++) {
				Chicken chicken = chickens.get(j);
				if(!chicken.used) continue;
				
				int x2 = chicken.i;
				int y2 = chicken.j;
				dist[x1][y1] = Math.min(min, Math.abs(x1 - x2) + Math.abs(y1 - y2));
				min = dist[x1][y1];
			}
		}
		
		int sum = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sum += dist[i][j];
			}
		}
		
		ans = Math.min(ans, sum);
	}
	
	static class Chicken {
		int i;
		int j;
		boolean used;

		public Chicken(int i, int j, boolean used) {
			this.i = i;
			this.j = j;
			this.used = used;
		}
	}
}
