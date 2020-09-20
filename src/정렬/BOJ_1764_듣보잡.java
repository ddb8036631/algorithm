package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1764_듣보잡 {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(sc.nextLine());

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = sc.nextLine();
			if (set.contains(name)) {
				list.add(name);
			}
		}

		Collections.sort(list);
		StringBuffer sb = new StringBuffer();
		for (String s : list)
			sb.append(s + "\n");
		System.out.println(list.size());
		System.out.println(sb);
	}
}
