package 프로그래머스_Level1;

public class 자릿수더하기 {
    public static int solution(int n) {
        int answer = 0;
        while(n != 0) {
        	answer += n % 10;
        	n = n / 10;
        }
        return answer;
    }
    
    public static void main(String[] args) {
		int n = 123;
    	solution(n);
	}
}
