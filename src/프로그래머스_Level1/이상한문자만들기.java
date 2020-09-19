package 프로그래머스_Level1;

public class 이상한문자만들기 {
	public static String solution(String s) {
		String answer = "";
		String[] strs = s.split("");
		int cnt = 0;

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals(" ")) {
				cnt = 0;
			} else {
				if (cnt % 2 == 0) {
					cnt++;
					strs[i] = strs[i].toUpperCase();
				} else {
					cnt++;
					strs[i] = strs[i].toLowerCase();
				}
			}
			answer += strs[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		String s = "try hello world";
		solution(s);

	}
}
