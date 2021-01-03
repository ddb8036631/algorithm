package 자료구조;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 프로그래머스_L3_디스크컨트롤러 {
    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0;
        int cnt = 0;
        int idx = 0;

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] now = pq.poll();
                answer += end + now[1] - now[0];
                end += now[1];
                cnt++;
            }
        }

        return (int) Math.floor(answer / jobs.length);
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        solution(jobs);
    }
}
