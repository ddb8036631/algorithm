package 프로그래머스_Level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	static int N = 10000000;
	static boolean[] prime;

	public static int solution(String numbers) {
		prime = new boolean[N];
		prime[0] = true;
		prime[1] = true;

		eratos();

		Set<Integer> set = new HashSet<>();

		int[] arr = new int[numbers.length()];

		for (int i = 0; i < numbers.length(); i++) {
			arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
		}

		for (int i = 1; i <= numbers.length(); i++)
			perm(arr, 0, numbers.length(), i, set);

		return set.size();
	}

	public static void perm(int[] arr, int depth, int n, int k, Set<Integer> set) {
		if (depth == k) {
			String s = "";
			for (int i = 0; i < k; i++)
				s += arr[i];
			int num = Integer.parseInt(s);
			if (!prime[num])
				set.add(num);

			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k, set);
			swap(arr, i, depth);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void eratos() {
		for (int i = 2; i * i < N; i++) {
			for (int j = i * i; j < N; j += i) {
				if (!prime[j])
					prime[j] = true;
			}
		}
	}

	public static void main(String[] args) {
		String numbers1 = "17";
		String numbers2 = "011";

		solution(numbers2);
	}
}
