package SWEA_D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_9280_진용이네주차타워 {
	static int N, M;
	static int[] R, W;
	static boolean[] used;
	static int cnt;

	static Queue<Integer> input = new LinkedList<>();
	static Queue<Integer> wait = new LinkedList<>();

	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = new int[N];
			W = new int[M];
			for (int i = 0; i < N; i++)
				R[i] = sc.nextInt();
			for (int i = 0; i < M; i++) {
				W[i] = sc.nextInt();
				input.add(W[i]);
			}
			
			while(!input.isEmpty()) {
				if(cnt < N && wait.isEmpty()) {
					int now = input.poll();
					
					if(now > 0) {
						
					} else if(now < 0) {
						
					}
				}
			}

		}
	}
}
