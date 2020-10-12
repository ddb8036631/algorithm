package 문자열;

import java.util.Scanner;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			boolean[] check = new boolean[26];
			boolean flag = true;

			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {

				// 해당 문자가 처음 등장할 때 true처리하고 끝.
				if (!check[s.charAt(j) - 'a'])
					check[s.charAt(j) - 'a'] = true;

				// 해당 문자가 처음 등장하지 않고, 전 문자와 같은 경우 : continue.
				else if (j > 0 && s.charAt(j - 1) == s.charAt(j))
					continue;

				// 해당 문자가 처음 등장하지 않고, 전 문자와도 다른 경우 : 제외.
				else {
					flag = false;
					break;
				}
			}

			if (flag)
				cnt++;
		}

		System.out.println(cnt);
	}
}
