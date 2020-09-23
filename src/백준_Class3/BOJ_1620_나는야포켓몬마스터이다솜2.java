package 백준_Class3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1620_나는야포켓몬마스터이다솜2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Map<Integer, String> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String s = sc.next();
			map1.put(i, s);
			map2.put(s, i);
		}

		for (int i = 1; i <= M; i++) {
			if (sc.hasNextInt()) {
				System.out.println(map1.get(sc.nextInt()));
			} else {
				System.out.println(map2.get(sc.next()));
			}
		}
	}
}
