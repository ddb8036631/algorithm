package 프로그래머스_Level2;

public class 피보나치수 {
    static final int MOD = 1234567;

    public static int solution(int n) {
        int answer = 0;
        int[] fibo = new int[n + 1];
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % MOD;
        }

        return fibo[n];
    }

    public static void main(String[] args) {
        int n = 3;
//        int n = 5;

        System.out.println(solution(n));
    }
}
