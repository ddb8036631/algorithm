package 수학;

import java.util.Scanner;

public class BOJ_14490_백대열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splited = sc.nextLine().split(":");
        int N = stoi(splited[0]);
        int M = stoi(splited[1]);
        int GCD = gcd(Math.max(N, M), Math.min(N, M));

        System.out.println(N / GCD + ":" + M / GCD);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}
