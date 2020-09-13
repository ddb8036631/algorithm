package 프로그래머스_Level1;

public class 콜라츠추측 {
    public static int solution(long num) {
        int answer = 0;
        
        // 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
        while(num != 1) {
        	if(answer == 500)
        		return -1;
        	
        	// 1-1. 입력된 수가 짝수라면 2로 나눕니다.
        	if(num % 2 == 0) {
        		num /= 2;
        		answer++;
        	}

        	// 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
        	else {
        		num = num * 3 + 1;
        		answer++;
        	}
        }
        
        System.out.println(num);
        return answer;
    }
    
    public static void main(String[] args) {
		int n = 626331;
		System.out.println(solution(n));
	}
}
