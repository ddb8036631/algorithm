package 카카오2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> list = new ArrayList<>();

        for (int stage = 1; stage <= N; stage++) {
            int notClearCnt = 0;
            int reachedCnt = 0;

            for (int i = 0; i < stages.length; i++) {
                if (stages[i] >= stage)
                    reachedCnt++;
                if (stages[i] == stage)
                    notClearCnt++;
            }

            if (reachedCnt == 0)
                list.add(new Stage(stage, 0));
            else
                list.add(new Stage(stage, (double) notClearCnt / reachedCnt));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stageIdx;
        }

        return answer;
    }

    private static class Stage implements Comparable<Stage> {
        int stageIdx;
        double failPercent;

        public Stage(int stageIdx, double failPercent) {
            this.stageIdx = stageIdx;
            this.failPercent = failPercent;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failPercent == o.failPercent) {
                return this.stageIdx - o.stageIdx;
            } else {
                return Double.compare(o.failPercent, this.failPercent);
            }
        }
    }

    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
//        solution(4, new int[]{4, 4, 4, 4, 4});
    }
}
