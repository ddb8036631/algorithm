package 수학;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BOJ_2476_주사위게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;

		for (int i = 0; i < N; i++) {
			Map<Integer, Integer> map = new HashMap<>();

			for (int j = 0; j < 3; j++) {
				int dice = sc.nextInt();
				if (map.containsKey(dice)) {
					int value = map.get(dice) + 1;
					map.remove(dice);
					map.put(dice, value);
				} else {
					map.put(dice, 1);
				}

			}

			List<Integer> list = new ArrayList<>(map.keySet());

			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return map.get(o2) - map.get(o1);
				}
			});

			int sum = 0;
			int key = list.get(list.size() - 1);
			if (map.get(key) == 3) {
				sum = 10000 + key * 1000;
			} else if (map.get(key) == 2) {
				sum = 1000 + key * 100;
			} else {
				Collections.sort(list);
				sum = list.get(list.size() - 1) * 100;
			}

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
