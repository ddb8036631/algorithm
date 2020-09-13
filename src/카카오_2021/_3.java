package 카카오_2021;

import java.util.Scanner;

public class _3 {
	static public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (int i = 0; i < query.length; i++) {
			int cnt = 0;

			String q = query[i];

			String[] tokens = q.split(" and ");
			String qLan = tokens[0];
			String qPart = tokens[1];
			String qLevel = tokens[2];
			String qFood = tokens[3].split(" ")[0];
			String qScore = tokens[3].split(" ")[1];


			for (int j = 0; j < info.length; j++) {
				String[] iTokens = info[j].split(" ");
				String iLan = iTokens[0];
				String iPart = iTokens[1];
				String iLevel = iTokens[2];
				String iFood = iTokens[3];
				String iScore = iTokens[4];

				if ((qLan.equals("-") || qLan.equals(iLan)) 
						&& (qPart.equals("-") || qPart.equals(iPart))
						&& (qLevel.equals("-") || qLevel.equals(iLevel))
						&& (qFood.equals("-") || qFood.equals(iFood))
						&& Integer.parseInt(qScore) <= Integer.parseInt(iScore))
					cnt++;

			}
		
			answer[i] = cnt;
		}

		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] info = new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };

		String[] query = new String[] { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		solution(info, query);
	}
}
