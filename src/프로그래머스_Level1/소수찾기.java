package 프로그래머스_Level1;

public class 소수찾기 {
    public static int solution(int n) {
        int answer = 0;
        
        boolean[] prime = new boolean[n+1];
        for(int i = 2; i*i<n; i++) {
        	for(int j=i*i; j<=n; j+=i) {
        		prime[j] = true;
        	}
        }
        
        for(int i=2; i<=n; i++) {
        	if(!prime[i])
        		answer++;
        }
        return answer;
    }
    
    public static void main(String[] args) {
//		int n = 4;
		int n = 10;
//		int n = 5;
		System.out.println(solution(n));
	}
}
