package 모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12764_싸지방에간준하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        while (N-- > 0) list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> occupied = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> vacant = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int[] chairs = new int[100001];
        int newIdx = 1;

        for (int[] time : list) {
            while (!occupied.isEmpty() && occupied.peek()[0] <= time[0]) {
                vacant.add(occupied.poll()[1]);
            }

            if (vacant.isEmpty()) {
                occupied.add(new int[]{time[1], newIdx});
                chairs[newIdx]++;
                newIdx++;
            } else {
                int vacantIdx = vacant.poll();
                occupied.add(new int[]{time[1], vacantIdx});
                chairs[vacantIdx]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 1; i < chairs.length; i++) {
            if (chairs[i] == 0) break;

            cnt++;
            sb.append(chairs[i] + " ");
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
