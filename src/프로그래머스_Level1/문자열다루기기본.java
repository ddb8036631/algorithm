package 프로그래머스_Level1;

public class 문자열다루기기본 {
    public static boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
        	return s.matches("^[0-9]*$");
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		String s = "1234";
		System.out.println(solution(s));
	}
}
