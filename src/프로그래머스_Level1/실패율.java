package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 실패율 {
	static class Stage {
		int stageIdx;
		double failPercent;
		
		public Stage(int stageIdx, double failPercent) {
			this.stageIdx = stageIdx;
			this.failPercent = failPercent;
		}
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		ArrayList<Stage> list = new ArrayList<>();
		
		for(int stage=1; stage<=N; stage++) {
			int notClearCnt = 0;
			int reachedCnt = 0;
			for(int i=0; i<stages.length; i++) {
				if(stages[i] >= stage)
					reachedCnt++;
				if(stages[i] == stage)
					notClearCnt++;
			}
			
			if(reachedCnt == 0)
				list.add(new Stage(stage, 0));
			else
				list.add(new Stage(stage, (double) notClearCnt / reachedCnt));
		}
		
		Collections.sort(list, new Comparator<Stage>() {

			@Override
			public int compare(Stage o1, Stage o2) {
				if(o1.failPercent == o2.failPercent) {
					return o1.stageIdx - o2.stageIdx;
				} else {
					return Double.compare(o2.failPercent, o1.failPercent);
				}
			}
		});

		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i).stageIdx;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int N1 = 5;
		int[] stages1 = { 2, 1, 2, 6, 2, 4, 3, 3 };

		int N2 = 4;
		int[] stages2 = { 4, 4, 4, 4, 4 };
		
		solution(N1, stages1);
//		solution(N2, stages2);
	}
}
