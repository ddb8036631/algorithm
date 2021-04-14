package 문자열;

import java.util.Scanner;

public class BOJ_2671_잠수함식별 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(input.matches("(100+1+|01)+") ? "SUBMARINE" : "NOISE");
    }
}
