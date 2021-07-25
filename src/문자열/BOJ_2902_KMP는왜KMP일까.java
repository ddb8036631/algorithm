package 문자열;

import java.util.Scanner;

public class BOJ_2902_KMP는왜KMP일까 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splited = sc.nextLine().split("-");

        for (String s : splited) {
            System.out.print(s.charAt(0));
        }
    }
}
