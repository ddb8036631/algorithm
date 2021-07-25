package 모의테스트;

import java.util.*;

public class BOJ_1599_민식어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<Word> list = new ArrayList<>();
        Word[] words = new Word[N];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] splited = new String[50];
            int target = 0;

            for (int j = 0; j < s.length(); j++) {
                if (j < s.length() - 1 && s.charAt(j) == 'n' && s.charAt(j + 1) == 'g') {
                    splited[target++] = "ng";
                    j++;
                } else {
                    splited[target++] = String.valueOf(s.charAt(j));
                }
            }

            int[] converted = new int[target];
            for (int j = 0; j < target; j++) {
                converted[j] = convert(splited[j]);
            }

            words[i] = new Word(s, converted);
            list.add(words[i]);
        }

        Collections.sort(list, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int idx = 0;

                while (idx < o1.converted.length && idx < o2.converted.length) {
                    if (o1.converted[idx] == o2.converted[idx]) {
                        idx++;
                        continue;
                    }
                    return o1.converted[idx] - o2.converted[idx];
                }
                return o1.converted.length - o2.converted.length;
            }
        });

        for (Word w : list) System.out.println(w.w);
    }

    static int convert(String s) {
        switch (s) {
            case "a": return 0;
            case "b": return 1;
            case "k": return 2;
            case "d": return 3;
            case "e": return 4;
            case "g": return 5;
            case "h": return 6;
            case "i": return 7;
            case "l": return 8;
            case "m": return 9;
            case "n": return 10;
            case "ng": return 11;
            case "o": return 12;
            case "p": return 13;
            case "r": return 14;
            case "s": return 15;
            case "t": return 16;
            case "u": return 17;
            case "w": return 18;
            case "y": return 19;
        }

        return 0;
    }

    static class Word {
        String w;
        int[] converted;

        public Word(String w, int[] converted) {
            this.w = w;
            this.converted = converted;
        }
    }
}
