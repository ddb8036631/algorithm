package 백준_Class2;

import java.util.Scanner;

public class BOJ_15829_Hashing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		long answer = 0;
		final int MOD = 1234567891;

		long[] pow = new long[50];
		pow[0] = 1;
		for (int i = 1; i < 50; i++) {
			pow[i] = pow[i - 1] * 31 % MOD;
		}

		for (int i = 0; i < L; i++) {
			answer = (answer + (s.charAt(i) - 'a' + 1) * pow[i]) % MOD;
		}

		System.out.println(answer);
	}
}
