package 프로그래머스_Level1;

public class 다트게임 {
	public static int solution(String dartResult) {
		int answer = 0;
		String[] strs = new String[3];
		int[] scores = new int[3];

		int idx = 0, cnt = 0;
		while (cnt != 3) {
			if (dartResult.charAt(idx) - '0' >= 0 && dartResult.charAt(idx) - '0' <= 9) {
				if (dartResult.charAt(idx + 1) - '0' >= 0 && dartResult.charAt(idx + 1) - '0' <= 9) {
					if (idx + 3 >= dartResult.length()) {
						strs[cnt++] = dartResult.substring(idx, dartResult.length());
						continue;
					}

					if (dartResult.charAt(idx + 3) == '*' || dartResult.charAt(idx + 3) == '#') {
						strs[cnt++] = dartResult.substring(idx, idx + 4);
						idx += 4;
					} else {
						strs[cnt++] = dartResult.substring(idx, idx + 3);
						idx += 3;
					}

				} else {
					if (idx + 2 >= dartResult.length()) {
						strs[cnt++] = dartResult.substring(idx, dartResult.length());
						continue;
					}

					if (dartResult.charAt(idx + 2) == '*' || dartResult.charAt(idx + 2) == '#') {
						strs[cnt++] = dartResult.substring(idx, idx + 3);
						idx += 3;
					} else {
						strs[cnt++] = dartResult.substring(idx, idx + 2);
						idx += 2;
					}
				}
			}
		}

		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];

			int score = 0;
			char bonus = '\0';
			char option = '\0';

			if (s.charAt(1) - '0' >= 0 && s.charAt(1) - '0' <= 9) {
				score = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
				bonus = s.charAt(2);
				if (s.length() == 4)
					option = s.charAt(3);
			} else {
				score = s.charAt(0) - '0';
				bonus = s.charAt(1);
				if (s.length() == 3)
					option = s.charAt(2);
			}

			switch (bonus) {
			case 'S':
				scores[i] = (int) Math.pow(score, 1);
				break;
			case 'D':
				scores[i] = (int) Math.pow(score, 2);
				break;
			case 'T':
				scores[i] = (int) Math.pow(score, 3);
				break;
			}

			switch (option) {
			case '\0':
				break;
			case '*':
				if (i - 1 >= 0) {
					scores[i - 1] *= 2;
				}
				scores[i] *= 2;
				break;
			case '#':
				scores[i] *= -1;
				break;
			}
		}
		
		for (int score : scores)
			answer += score;

		return answer;
	}

	public static void main(String[] args) {
		String dartResult1 = "1S2D*3T";
		String dartResult2 = "1D2S#10S";
		String dartResult3 = "1D2S0T";
		String dartResult4 = "1S*2T*3S";
		String dartResult5 = "1D#2S*3S";
		String dartResult6 = "1T2D3D#";
		String dartResult7 = "1D2S3T*";

		solution(dartResult7);
	}
}
