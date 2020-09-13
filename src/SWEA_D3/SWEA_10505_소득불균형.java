package SWEA_D3;

import java.util.Scanner;

public class SWEA_10505_소득불균형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			int avg = sum / N;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] <= avg)
					ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
