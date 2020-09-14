package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class 두개뽑아서더하기 {
	public static ArrayList<Integer> solution(int[] numbers) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			answer.add(iter.next());
		}
		
		Collections.sort(answer);
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		solution(numbers);
	}
}
