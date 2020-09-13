package 동적계획법;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	static int N, L;
	static int[] T;
	static int[] K;
	
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			N=sc.nextInt();
			L=sc.nextInt();
			
			T=new int[N+1];
			K=new int[N+1];
			
			memo=new int[N+1][L+1];
			
			for(int i=1; i<=N; i++) {
				T[i]=sc.nextInt();
				K[i]=sc.nextInt();
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=0; j<=L; j++) {
					if(K[i]>j) {
						memo[i][j] = memo[i-1][j];
					} else {
						int val1 = memo[i-1][j-K[i]] + T[i];
						int val2 = memo[i-1][j];
						memo[i][j] = Math.max(val1, val2);
					}
				}
			}
			
			System.out.println("#"+tc+" "+memo[N][L]);
		}
	}
}
