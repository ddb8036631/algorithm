package 프로그래머스_Level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) == o2.charAt(n))
					return o1.compareTo(o2);
				return o1.charAt(n) - o2.charAt(n);
			}
        	
        	
		});
        
        return strings;
    }
    
	public static void main(String[] args) {
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		solution(strings, n);
	}
}
