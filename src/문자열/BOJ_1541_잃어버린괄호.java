package 문자열;

import java.util.Scanner;

public class BOJ_1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        boolean minus = false;
        String tmp = "";
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == '+' || now == '-') {
                if (minus)
                    result -= Integer.parseInt(tmp);
                else
                    result += Integer.parseInt(tmp);

                tmp = "";

                if (now == '-') minus = true;
            } else {
                tmp += now;
            }
        }

        if (minus)
            result -= Integer.parseInt(tmp);
        else
            result += Integer.parseInt(tmp);

        System.out.println(result);
    }
}
