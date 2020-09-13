package 프로그래머스_Level1;

public class 문자열을정수로바꾸기 {
    public static int solution(String s) {
        return Integer.parseInt(s);
    }
    
	public static void main(String[] args) {
		String s = "1234";
//		String s = "-1234";
		
		solution(s);
		
	}
}
