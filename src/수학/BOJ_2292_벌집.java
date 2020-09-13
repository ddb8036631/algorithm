package 수학;

import java.util.Scanner;

public class BOJ_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long limit = 1;
		int cnt = 1;
		while(true) {
			if(limit >= n) break;
			limit += 6 * cnt;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
