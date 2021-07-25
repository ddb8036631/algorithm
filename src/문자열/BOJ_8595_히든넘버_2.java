package 문자열;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_8595_히든넘버_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String word = sc.next();
        long sum = 0;

        Pattern pattern = Pattern.compile("([\\d]+)[a-zA-Z]+([\\d]+)");
        Matcher matcher = pattern.matcher(word);
        int idx = 0;
        boolean first = true;

        while (matcher.find(idx)) {
            if (first) {
                sum += Integer.parseInt(matcher.group(1));
                first = false;
            }

            sum += Integer.parseInt(matcher.group(2));
            idx = matcher.end() - 1;
        }

        System.out.println(sum);
    }
}