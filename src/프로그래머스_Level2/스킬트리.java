package 프로그래머스_Level2;

import java.util.Scanner;

public class 스킬트리 {
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String skill_tree : skill_trees) {
			boolean[] visit = new boolean[26];
			boolean flag = true;

			int i = 0;
			int j = 0;

			while (true) {
				if (i == skill.length() || j == skill_tree.length())
					break;

				if (visit[skill.charAt(i) - 'A']) {
					flag = false;
					break;
				}

				if (skill.contains(skill_tree.charAt(j) + "")) {
					visit[skill.charAt(i) - 'A'] = true;
					if (skill.charAt(i) == skill_tree.charAt(j)) {
						i++;
						j++;
					} else {
						if (skill.charAt(i) < skill_tree.charAt(j)) {
							flag = false;
							break;
						}
						j++;
					}
				} else
					j++;
			}

			if (flag)
				answer++;

		}

		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String skill = "CBD";
//		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
//		String[] skill_trees = { "CED" };
		String[] skill_trees = { "ASF" };

		System.out.println(solution(skill, skill_trees));
	}
}
