package 완전탐색;

import java.util.Scanner;

public class BOJ_14888_연산자끼워넣기 {
	static int N;
	static int[] numbers;
	static int[] op_counts = new int[4];
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for(int i=0; i<N; i++)
			numbers[i] = sc.nextInt();
		
		for(int i=0; i<4; i++) {
			op_counts[i] = sc.nextInt();
		}
		
		
		
	}
}
