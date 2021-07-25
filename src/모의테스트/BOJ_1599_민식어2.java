package 모의테스트;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BOJ_1599_민식어2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        IntStream.range(0, N)
                .mapToObj(e -> sc.next().replace('k', 'c').replace("ng", "N"))
                .sorted((s1, s2) -> {
                    int len1 = s1.length(), len2 = s2.length();

                    for (int i = 0; i < Math.min(len1, len2); i++) {
                        double ascii1 = getAscii(s1.charAt(i)), ascii2 = getAscii(s2.charAt(i));
                        if (ascii1 != ascii2) return Double.compare(ascii1, ascii2);
                    }
                    return len1 - len2;
                })
                .map(s -> s.replace('c', 'k').replace("N", "ng"))
                .forEach(System.out::println);
    }

    static double getAscii(char ch) {
        return ch == 'N' ? 'n' + 0.5 : ch;
    }
}
