package 동적계획법;

public class 프로그래머스_L3_정수삼각형 {
    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] memo = new int[triangle.length][triangle.length];

        memo[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    memo[i][j] = memo[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    memo[i][j] = memo[i - 1][j - 1] + triangle[i][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j - 1], memo[i - 1][j]) + triangle[i][j];
                }
            }
        }

        for (int sum : memo[triangle.length - 1]) {
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        solution(triangle);
    }
}
