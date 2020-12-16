package 프로그래머스_Level2;

public class N개의최소공배수 {
    public static int solution(int[] arr) {
        int val = arr[0];

        for (int i = 1; i < arr.length; i++) {
            val = lcm(val, arr[i]);
        }

        return val;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
//        int[] arr = {1, 2, 3};
        System.out.println(solution(arr));
    }
}
