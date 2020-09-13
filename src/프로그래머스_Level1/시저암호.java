package 프로그래머스_Level1;

public class 시저암호 {
    public static String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (Character.isLowerCase(ch)) {
				ch = (char) ((ch + n - 'a') % 26 + 'a');
			} else if (Character.isUpperCase(ch)) {
				ch = (char) ((ch + n - 'A') % 26 + 'A');
			}

			answer += ch;
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	String s = "AB";
    	int n = 1;
//    	String s = "ZAB";
//    	int n = 25;
//    	String s = "a B z";
//    	int n = 4;
    	
    	solution(s, n);
    	
	}
}
