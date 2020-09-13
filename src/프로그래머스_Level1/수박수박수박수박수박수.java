package 프로그래머스_Level1;

public class 수박수박수박수박수박수 {
    public static String solution(int n) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i< n/2; i++) {
        	sb.append("수박");
        }
        if(n%2 == 1)
        	sb.append("수");
        
        return sb.toString();
    }
    
    
	public static void main(String[] args) {
//		int n = 3;
		int n = 4;
		solution(n);
	}
}
