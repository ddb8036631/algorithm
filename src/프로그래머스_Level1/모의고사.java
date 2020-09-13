package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
	public static List<Integer> solution(int[] answers) {
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		int[] oneAnswer = {1, 2, 3, 4, 5};
		int[] twoAnswer = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] threeAnswer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == oneAnswer[i%oneAnswer.length])
				cnt1++;
			if(answers[i] == twoAnswer[i%twoAnswer.length])
				cnt2++;
			if(answers[i] == threeAnswer[i%threeAnswer.length])
				cnt3++;
		}
		
		int max = cnt1;
		max = Math.max(max, cnt2);
		max = Math.max(max, cnt3);
		
		List<Integer> answer = new ArrayList<>();
		if(max == cnt1)
			answer.add(1);
		if(max == cnt2)
			answer.add(2);
		if(max == cnt3)
			answer.add(3);
		
        return answer;
	}
	
	public static void main(String[] args) {
//		int[] answers = {1, 2, 3, 4, 5};
		int[] answers = {1, 3, 2, 4, 2};
		solution(answers);
	}
}
