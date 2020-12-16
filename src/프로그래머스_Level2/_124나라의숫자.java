package 프로그래머스_Level2;

public class _124나라의숫자 {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            n = n / 3;

            if (remainder == 0) {
                remainder = 4;
                n--;
            }

            sb.insert(0, remainder);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 1;
//        int n = 2;
//        int n = 3;
//        int n = 4;

        System.out.println(solution(n));
    }
}
