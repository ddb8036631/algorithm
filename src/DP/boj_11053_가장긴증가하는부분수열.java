package dp;

import java.util.Scanner;

public class boj_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[] A = new int[N];
		int[] D=new int[N];
		
		for(int i=0; i<N; i++)
			A[i] = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			D[i] = 1;
			for(int j=0; j<i; j++) {
				if(A[j]<A[i] && D[i]<D[j]+1)
					D[i] = D[j]+1;
			}
		}
		int ans=0;
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, D[i]);
		}
		
		System.out.println(ans);
	}
}
