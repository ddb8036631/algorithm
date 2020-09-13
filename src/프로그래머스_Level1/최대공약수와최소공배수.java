package 프로그래머스_Level1;

public class 최대공약수와최소공배수 {
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int nm = n*m;
        
        if(n < m) {
        	int tmp = m;
        	m = n;
        	n = tmp;
        }
        
        while(m != 0) {
        	int r = n % m;
        	n = m;
        	m = r;
        }
        
        answer[0] = n;
        answer[1] = nm / n;
        
        return answer;
    }
    
	public static void main(String[] args) {
//		int n = 3;
//		int m = 12;
		int n = 2;
		int m = 5;
		solution(n, m);
		
	}
}
