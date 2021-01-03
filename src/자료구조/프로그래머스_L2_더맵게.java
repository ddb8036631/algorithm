package 자료구조;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 프로그래머스_L2_더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int sco : scoville)
            pq.add(sco);

        boolean flag = true;

        while (true) {
            if (pq.peek() >= K) {
                break;
            }

            if (pq.size() == 1) {
                flag = false;
                break;
            }

            int a = pq.poll();
            int b = pq.poll();

            pq.add(a + b * 2);
            answer++;
        }

        return flag ? answer : -1;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        solution(scoville, K);
    }
}
