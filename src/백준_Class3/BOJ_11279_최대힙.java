package 백준_Class3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11279_최대힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
		});

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (pq.isEmpty())
					sb.append("0\n");
				else
					sb.append(pq.poll() + "\n");
			} else {
				pq.add(num);
			}
		}
		System.out.println(sb);
	}
}
