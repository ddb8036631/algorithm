package 수학;

import java.util.Scanner;

public class BOJ_1085_직사각형에서탈출 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x, y, w, h;
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		
		int ans = 1000;
		ans = Math.min(ans, x);
		ans = Math.min(ans, y);
		ans = Math.min(ans, h-y);
		ans = Math.min(ans, w-x);
		
		System.out.println(ans);
	}
}
