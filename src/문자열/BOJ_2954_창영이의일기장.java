package 문자열;

import java.util.Scanner;

public class BOJ_2954_창영이의일기장 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.replaceAll("apa", "a").replaceAll("epe", "e")
                .replaceAll("ipi", "i").replaceAll("opo", "o").replaceAll("upu", "u");
        System.out.println(input);
    }
}
