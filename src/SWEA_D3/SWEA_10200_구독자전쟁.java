package SWEA_D3;

import java.util.Scanner;

public class SWEA_10200_구독자전쟁 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();

			// 최대
			int max = 0;
			boolean[] arr = new boolean[N];
			for (int i = 0; i < A; i++) {
				arr[i] = true;
			}
			for (int i = 0; i < B; i++) {
				if (arr[i] == false)
					break;
				else
					max++;
			}

			// 최소
			int min = B;
			arr = new boolean[N];
			int i;
			for (i = 0; i < A; i++) {
				arr[i] = true;
			}

			for (int j = 0; j < B; j++) {
				if (j + i < N) {
					arr[i] = true;
					min--;
				}
			}

			System.out.println("#" + tc + " " + max + " " + min);
		}
	}
}
