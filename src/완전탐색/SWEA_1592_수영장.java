package bruteforce;

import java.util.Scanner;

public class SWEA_1592_수영장 {
	static int[] cost;
	static int[] month;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			cost = new int[4];
			for(int i=0; i<cost.length; i++)
				cost[i] = sc.nextInt();
			month = new int[13];
			for(int i=1; i<=month.length-1; i++)
				month[i] = sc.nextInt();
			
			min = Integer.MAX_VALUE;
			solve(1, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void solve(int mon, int sum) {
		if(mon >= 13) {
			min = Math.min(min, sum);
			return;
		}
		
		solve(mon + 1, sum + month[mon] * cost[0]);
		solve(mon + 1, sum + cost[1]);
		solve(mon + 3, sum + cost[2]);
		solve(mon + 12, sum + cost[3]);
	}
}
