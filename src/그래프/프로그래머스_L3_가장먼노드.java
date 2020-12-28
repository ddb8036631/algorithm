package 그래프;

import java.util.*;

public class 프로그래머스_L3_가장먼노드 {
    public static int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] visit = new boolean[n + 1];
        List<int[]> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        visit[1] = true;
        queue.add(1);

        int cnt = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int now = queue.poll();

                for (int i = 0; i < edge.length; i++) {
                    if (edge[i][0] == now && !visit[edge[i][1]]) {
                        visit[edge[i][1]] = true;
                        queue.add(edge[i][1]);
                        list.add(new int[]{edge[i][1], cnt + 1});
                    } else if (edge[i][1] == now && !visit[edge[i][0]]) {
                        visit[edge[i][0]] = true;
                        queue.add(edge[i][0]);
                        list.add(new int[]{edge[i][0], cnt + 1});
                    }
                }
            }

            cnt++;
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int[] arr : list) {
            if (arr[1] != list.get(0)[1]) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        solution(n, vertex);
    }
}
