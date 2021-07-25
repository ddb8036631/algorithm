package 모의테스트;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1599_민식어3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String template = "abkdeghilmncoprstuwy";
        HashMap<Character, Character> map = new HashMap<>();
        Word[] words = new Word[N];

        for (int i = 0; i < 20; i++) map.put(template.charAt(i), (char) ('a' + i));

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            words[i] = new Word();
            words[i].before = s;
            s = s.replace("ng", "c");
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); j++) sb.append(map.get(s.charAt(j)));

            words[i].after = sb.toString();
        }

        Arrays.sort(words, Comparator.comparing(w -> w.after));
        for (Word w : words) System.out.println(w.before);
    }

    static class Word {
        String before, after;
    }
}
