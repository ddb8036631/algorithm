package 수학;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1978_소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		boolean[] arr = new boolean[1001];
		Arrays.fill(arr, true);
		arr[1] = false;
		
		int N = sc.nextInt();
		int[] input = new int[N];
		for(int i=0; i<N; i++)
			input[i] = sc.nextInt();
		
		for(int i = 2; i<=1000; i++) {
			for(int j = i+1; j<= 1000; j++) {
				if(arr[j] == false) continue;
				if(j % i == 0)
					arr[j] = false;
			}
		}
		
		for(int i=0; i<N; i++) {
			if(arr[input[i]])
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
