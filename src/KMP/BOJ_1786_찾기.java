package KMP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1786_찾기 {
    static String T, P;
    static int cnt;
    static List<Integer> idxList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextLine();
        P = sc.nextLine();

        KMP();

        System.out.println(cnt);
        for (int idx : idxList)
            System.out.print(idx + " ");
    }

    public static int[] getPi() {
        int[] pi = new int[P.length()];

        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }

            if (P.charAt(i) == P.charAt(j))
                pi[i] = ++j;
        }

        return pi;
    }

    public static void KMP() {
        int[] pi = getPi();

        int j = 0;
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }

            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    cnt++;
                    idxList.add(i - P.length() + 2);

                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }
}
