package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {
	static int[] di = {0, -1, 0, 1, 0};
	static int[] dj = {0, 0, 1, 0, -1};
	static List<BatteryCharger> list;
	static List<BatteryCharger> container_A;
	static List<BatteryCharger> container_B;
	static int ax, ay, bx, by;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] move_A = new int[M+1];
			int[] move_B = new int[M+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				move_A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				move_B[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList<>();
			container_A = new ArrayList<>();
			container_B = new ArrayList<>();
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int coverage = Integer.parseInt(st.nextToken());
				int performance = Integer.parseInt(st.nextToken());
				
				list.add(new BatteryCharger(i, x, y, coverage, performance));
			}
			
			ax = ay = 1;
			bx = by = 10;
			
			ans = 0;
			for(int time=0; time<=M; time++) {
				ax += di[move_A[time]];
				ay += dj[move_A[time]];
				bx += di[move_B[time]];
				by += dj[move_B[time]];

				ans += calc();
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static int calc() {
		for(BatteryCharger bc : list) {
			if(isRange(ax, ay, bc))
				container_A.add(bc);
			if(isRange(bx, by, bc))
				container_B.add(bc);
		}
		
		int maxPerformance = 0;
		if(container_A.size() == 0) {
			for(BatteryCharger bc : container_B) {
				maxPerformance = Math.max(maxPerformance, bc.performance);
			}
		}

		if(container_B.size() == 0) {
			for(BatteryCharger bc : container_A) {
				maxPerformance = Math.max(maxPerformance, bc.performance);
			}
		}
		
		if(container_A.size() >= 1 && container_B.size() >= 1) {
			for(BatteryCharger bc_a : container_A) {
				for(BatteryCharger bc_b : container_B) {
					if(bc_a.idx == bc_b.idx) {
						maxPerformance = Math.max(maxPerformance, bc_a.performance);
					} else {
						maxPerformance = Math.max(maxPerformance, bc_a.performance + bc_b.performance);
					}
				}
			}
		}
		
		container_A.clear();
		container_B.clear();
		
		return maxPerformance;
	}
	
	static boolean isRange(int i, int j, BatteryCharger bc) {
		if(Math.abs(i-bc.i) + Math.abs(j-bc.j) <= bc.coverage)
			return true;
		return false;
	}

	static class BatteryCharger {
		int idx, i, j, coverage, performance;

		public BatteryCharger(int idx, int i, int j, int coverage, int performance) {
			this.idx = idx;
			this.i = i;
			this.j = j;
			this.coverage = coverage;
			this.performance = performance;
		}
	}
}
