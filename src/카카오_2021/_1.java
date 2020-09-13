package 카카오_2021;

import java.util.Scanner;

public class _1 {
	public static String solution(String new_id) {
		String answer = "";
		StringBuffer sb = new StringBuffer();

		// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		new_id = new_id.toLowerCase();
//		System.out.println("1단계 후 : " + new_id);

		// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (c >= 'a' && c <= 'z') {
				sb.append(c);
				continue;
			}
			if (c >= '0' && c <= '9') {
				sb.append(c);
				continue;
			}
			if (c == '-' || c == '_' || c == '.') {
				sb.append(c);
				continue;
			}
		}
//		System.out.println("2단계 후 : " + sb);

		// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == '.') {
				int j = i + 1;
				while (j < sb.length() && sb.charAt(j) == '.')
					j++;
//				System.out.println("j : " + j);

				sb.replace(i, j, ".");
//				System.out.println(sb);
			}
		}

//		System.out.println("3단계 후 : " + sb);
		
		// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		new_id = sb.toString();
		if(new_id.length() == 1) {
			if(new_id.charAt(0) == '.')
				new_id = "";
		}
		else {
			if (new_id.charAt(0) == '.')
				new_id = new_id.substring(1, new_id.length());
			if (new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, new_id.length() - 1);
		}
//		System.out.println("4단계 후 : " + new_id);

		
		// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		sb = new StringBuffer(new_id);
		if(sb.length() == 0) {
			sb.append('a');
			new_id = "a";
		}
//		System.out.println("5단계 후 : " + sb);
		
		// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	    // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if(sb.length() >= 16) {
			new_id = sb.substring(0, 15);
			if (new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, new_id.length() - 1);
		}
		
		sb = new StringBuffer(new_id);
		
		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if(new_id.length() <= 2) {
			sb = new StringBuffer(new_id);
			char last = sb.charAt(sb.length() - 1);
			while(sb.length() != 3) {
//				System.out.println("sb.length() : " + sb.length());
				sb.append(last);
			}
		}
		
//		System.out.println(sb);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String new_id = sc.nextLine();

		System.out.println(solution(new_id));
	}
}
