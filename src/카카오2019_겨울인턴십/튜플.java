package 카카오2019_겨울인턴십;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 튜플 {
    public static List solution(String s) {
        List<Integer> answer = new ArrayList<>();
        int[] cnt = new int[100001];
        s = s.replace("{", "").replace("}", "");
        String[] splited = s.split(",");

        for (String str : splited) {
            cnt[Integer.parseInt(str)]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            pq.add(new int[]{i, cnt[i]});
        }

        while (!pq.isEmpty()) answer.add(pq.poll()[0]);

        return answer;
    }

    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
//        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
//        solution("{{20,111},{111}}");
//        solution("{{123}}");
//        solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }
}
