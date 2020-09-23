package 백준_Class3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11286_절댓값힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				if (Math.abs(o1.intValue()) == Math.abs(o2.intValue()))
					return o1.intValue() - o2.intValue();
				return Math.abs(o1.intValue()) - Math.abs(o2.intValue());
			}

		});

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			Long num = sc.nextLong();

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
