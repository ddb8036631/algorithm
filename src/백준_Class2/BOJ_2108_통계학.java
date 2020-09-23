package 백준_Class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BOJ_2108_통계학 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		System.out.println(Math.round((double) sum / N));

		System.out.println(arr[N / 2]);

		Map<Integer, Integer> map = new HashMap<>();
		for (int key : arr) {
			if (map.containsKey(key)) {
				int value = map.get(key);
				map.put(key, value + 1);
			} else {
				map.put(key, 1);
			}
		}

		List<int[]> list = new ArrayList<>();
		for (Integer key : map.keySet()) {
			list.add(new int[] { (int) key, (int) map.get(key) });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o2[1] - o1[1];
			}
		});

		if (list.size() >= 2) {
			if (list.get(0)[1] == list.get(1)[1])
				System.out.println(list.get(1)[0]);
			else
				System.out.println(list.get(0)[0]);
		} else
			System.out.println(list.get(0)[0]);

		System.out.println(arr[N - 1] - arr[0]);
	}
}
