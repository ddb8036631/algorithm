package ���α׷��ӽ�_Level1;

public class �ڸ������ϱ� {
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
