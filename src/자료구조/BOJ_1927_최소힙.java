package 자료구조;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1927_최소힙 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		N = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		});

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			if (num == 0) {
				if (pq.size() == 0)
					sb.append(0 + "\n");
				else
					sb.append(pq.poll() + "\n");
			} else
				pq.add(num);
		}
		System.out.println(sb);
	}
}
