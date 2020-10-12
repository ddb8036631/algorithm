package 수학;

import java.util.Scanner;

public class BOJ_1065_한수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num < 10)
			System.out.println(num);

		else {
			int cnt = 9;

			for (int i = 10; i <= num; i++) {
				boolean flag = true;

				String s = i + "";
				int[] arr = new int[s.length()];
				for (int j = 0; j < s.length(); j++) {
					arr[j] = s.charAt(j) - '0';
				}

				int delta = arr[1] - arr[0];

				for (int j = 2; j < s.length(); j++) {
					if (arr[j] - arr[j - 1] != delta) {
						flag = false;
						break;
					}
				}

				if (flag)
					cnt++;
			}

			System.out.println(cnt);
		}

	}
}
