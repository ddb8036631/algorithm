package 카카오2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 무지의먹방라이브 {
    public static long solution(int[] food_times, long k) {
        long sum = 0;
        long prev = 0;

        for (int time : food_times) sum += time;

        if (sum <= k) return -1;

        sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < food_times.length; i++) {
            pq.add(new int[]{food_times[i], i});
        }

        while (sum + (pq.peek()[0] - prev) * pq.size() <= k) {
            sum += (pq.peek()[0] - prev) * pq.size();
            prev = pq.peek()[0];
            pq.poll();
        }

        ArrayList<int[]> list = new ArrayList<>(pq);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        return list.get((int) ((k - sum) % list.size()))[1] + 1;
    }

    public static void main(String[] args) {
        solution(new int[]{3, 1, 2}, 5);
//        solution(new int[]{8, 6, 4}, 15);
    }
}
