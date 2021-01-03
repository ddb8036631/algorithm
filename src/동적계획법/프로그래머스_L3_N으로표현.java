package 동적계획법;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 프로그래머스_L3_N으로표현 {
    public static int solution(int N, int number) {
        Set<Integer>[] set = new Set[9];
        for (int i = 1; i < set.length; i++) {
            set[i] = new HashSet<>();
        }

        set[1].add(N);
        for (int i = 2; i < set.length; i++) {
            String tmp = "";

            for (int j = 0; j < i; j++)
                tmp += N;

            set[i].add(Integer.parseInt(tmp));

            for (int j = 1; j <= i / 2; j++) {
                Iterator<Integer> iter1 = set[j].iterator();

                while (iter1.hasNext()) {
                    int val1 = iter1.next();

                    Iterator<Integer> iter2 = set[i - j].iterator();
                    while (iter2.hasNext()) {
                        int val2 = iter2.next();

                        set[i].add(val1 + val2);
                        set[i].add(val1 - val2);
                        set[i].add(val1 * val2);
                        if (val2 != 0)
                            set[i].add(val1 / val2);

                        set[i].add(val2 + val1);
                        set[i].add(val2 - val1);
                        set[i].add(val2 * val1);
                        if (val1 != 0)
                            set[i].add(val2 / val1);
                    }
                }
            }
        }

        for (int i = 1; i <= 8; i++) {
            if (set[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 1;
        int number = 1121;

        solution(N, number);
    }
}
