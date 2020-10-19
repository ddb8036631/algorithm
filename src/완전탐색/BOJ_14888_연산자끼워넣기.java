package 완전탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_14888_연산자끼워넣기 {
	static int N;
	static int[] numbers;
	static int[] op_counts = new int[4];
	static List<Character> op;

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		op = new ArrayList<Character>();

		for (int i = 0; i < N; i++)
			numbers[i] = sc.nextInt();

		for (int i = 0; i < 4; i++) {
			op_counts[i] = sc.nextInt();
		}

		for (int i = 0; i < op_counts[0]; i++)
			op.add('+');
		for (int i = 0; i < op_counts[1]; i++)
			op.add('-');
		for (int i = 0; i < op_counts[2]; i++)
			op.add('*');
		for (int i = 0; i < op_counts[3]; i++)
			op.add('/');

		perm(op, 0, op.size(), op.size());
		System.out.println(max + "\n" + min);
	}

	static void perm(List<Character> arr, int depth, int n, int k) {
		if (depth == k) {
			calc();

			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}

	static void swap(List<Character> arr, int i, int j) {
		char tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}

	static void calc() {
		int sum = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			int tmp_num = numbers[i];
			char tmp_op = op.get(i - 1);

			switch (tmp_op) {
			case '+':
				sum += tmp_num;
				break;
			case '-':
				sum -= tmp_num;
				break;
			case '*':
				sum *= tmp_num;
				break;
			case '/':
				sum /= tmp_num;
				break;
			}
		}

		max = Math.max(max, sum);
		min = Math.min(min, sum);
	}
}
