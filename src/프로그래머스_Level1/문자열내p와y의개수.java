package 프로그래머스_Level1;

public class 문자열내p와y의개수 {
	public static boolean solution(String s) {
        s = s.toUpperCase();
        
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == 'P') pCnt++;
        	else if(s.charAt(i) == 'Y') yCnt++;
        }
        return pCnt==yCnt ? true : false;
    }
    
	public static void main(String[] args) {
		String s = "pPoooyY";
		solution(s);
	}
}
