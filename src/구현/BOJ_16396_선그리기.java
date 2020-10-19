package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16396_선그리기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10001];
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Arrays.fill(arr, x, y, 1);
		}

		int sum = 0;
		for (int i = 0; i < 10000; i++)
			sum += arr[i];
		System.out.println(sum);
	}
}
