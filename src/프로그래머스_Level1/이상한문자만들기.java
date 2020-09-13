package 프로그래머스_Level1;

public class 이상한문자만들기 {
	public static String solution(String s) {
		String answer = "";
		String[] strings = s.split(" ");
		
		for (int i = 0; i < strings.length; i++) {
			if(strings[i].equals(""))
				continue;
			for (int j = 0; j < strings[i].length(); j++) {
				char ch = strings[i].charAt(j);
				if (j % 2 == 0) {
					answer += Character.toUpperCase(ch);
				} else {
					answer += Character.toLowerCase(ch);
				}
			}
			answer += " ";
		}
		return answer.trim();
	}

	public static void main(String[] args) {
		String s = "try hello world";
		solution(s);

	}
}
