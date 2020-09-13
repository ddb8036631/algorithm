package 프로그래머스_Level1;

import java.util.HashMap;
import java.util.Iterator;

public class 완주하지못한선수 {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < participant.length; i++) {
			String key = participant[i];
			if (hashMap.containsKey(key)) {
				int value = hashMap.get(key);
				hashMap.put(participant[i], value + 1);
			} else
				hashMap.put(participant[i], 1);
		}

		for (int i = 0; i < completion.length; i++) {
			String key = completion[i];
			if (hashMap.containsKey(key)) {
				if (hashMap.get(key) == 1)
					hashMap.remove(key);
				else {
					int value = hashMap.get(key);
					hashMap.put(key, value - 1);
				}
			}
		}

		Iterator<String> keys = hashMap.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			answer = key;
		}

		return answer;
	}

	public static void main(String[] args) {
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
//		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant, completion));
	}
}
