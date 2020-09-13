package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 문자열내림차순으로배치하기 {
    public static String solution(String s) {
        String answer = "";
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++)
        	list.add(s.charAt(i));
        
        Collections.sort(list, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return o2.compareTo(o1);
			}
		});
        
        for(Character c : list)
        	answer += c;
        System.out.println(answer);
        
        return answer;
    }
    
	public static void main(String[] args) {
		String s = "Zbcdefg";
		solution(s);
	}
}
