package 프로그래머스_Level1;

public class 두정수사이의합 {
    public static long solution(int a, int b) {
        long answer = 0;
        
        for(int i=Math.min(a, b); i<=Math.max(a, b); i++) {
        	answer += i;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		int a = 3;
		int b = 5;
//		int a = 3;
//		int b = 3;
//		int a = 3;
//		int b = 5;
		System.out.println(solution(a, b));
		
	}
}
