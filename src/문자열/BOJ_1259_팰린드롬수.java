package 문자열;

import java.util.Scanner;

public class BOJ_1259_팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			String s = sc.next();
			if(Integer.parseInt(s) == 0) break;
			
			StringBuffer input = new StringBuffer();
			input.append(s);
			StringBuffer reverse = input.reverse();
			
			String r = reverse.toString();
			
			System.out.println(s.equals(r) ? "yes" : "no");
		}
	}
}
