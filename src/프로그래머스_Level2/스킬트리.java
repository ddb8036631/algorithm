package 프로그래머스_Level2;

import java.util.Scanner;

public class 스킬트리 {
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			boolean flag = true;
			String[] skill_tree = skill_trees[i].split("");
			int cnt = 0;

			for (int j = 0; j < skill_tree.length; j++) {
				if (cnt < skill.indexOf(skill_tree[j])) {
					flag = false;
					break;
				} else if (cnt == skill.indexOf(skill_tree[j])) {
					cnt++;
				}
			}
			if (flag) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String skill = "CBD";
//		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
//		String[] skill_trees = { "CED" };
//		String[] skill_trees = { "ASF" };
		String[] skill_trees = {"B"};
		System.out.println(solution(skill, skill_trees));
	}
}
