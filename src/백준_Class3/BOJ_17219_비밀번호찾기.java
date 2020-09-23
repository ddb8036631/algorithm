package 백준_Class3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_17219_비밀번호찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String[] strs = sc.nextLine().split(" ");
			map.put(strs[0], strs[1]);
		}

		for (int i = 0; i < M; i++) {
			System.out.println(map.get(sc.nextLine()));
		}
	}
}
