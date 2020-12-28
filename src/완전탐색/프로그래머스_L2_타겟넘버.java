package 완전탐색;

public class 프로그래머스_L2_타겟넘버 {
    static int cnt;

    public static int solution(int[] numbers, int target) {
        dfs(1, numbers[0], numbers, target);
        dfs(1, -numbers[0], numbers, target);

        return cnt;
    }

    public static void dfs(int idx, int sum, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (sum == target)
                cnt++;

            return;
        }

        dfs(idx + 1, sum + numbers[idx], numbers, target);
        dfs(idx + 1, sum - numbers[idx], numbers, target);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        solution(numbers, target);
    }
}
