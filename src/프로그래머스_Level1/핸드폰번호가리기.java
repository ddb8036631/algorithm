package 프로그래머스_Level1;

public class 핸드폰번호가리기 {
	public static String solution(String phone_number) {
		String answer = "";
		int len = phone_number.length();
		for (int i = 0; i < len; i++) {
			if (i < len - 4)
				answer += "*";
			else
				answer += phone_number.charAt(i);
		}
		return answer;
	}

	public static void main(String[] args) {
//		String phone_number = "01033334444";
//		String phone_number = "027778888";
		String phone_number = "4444";
		solution(phone_number);
	}
}
