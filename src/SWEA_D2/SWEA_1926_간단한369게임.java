package SWEA_D2;

import java.util.Scanner;

public class SWEA_1926_간단한369게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            s = s.replaceAll("3", "-").replaceAll("6", "-").replaceAll("9", "-");

            if (s.contains("-")) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '-') System.out.print("-");
                }
            } else System.out.print(s);

            System.out.print(" ");
        }
    }
}
