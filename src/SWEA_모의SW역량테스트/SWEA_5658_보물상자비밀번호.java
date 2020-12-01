package SWEA_모의SW역량테스트;

import java.util.*;

public class SWEA_5658_보물상자비밀번호 {
    static int N, K;
    static String input;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();

            input = sc.next();

            list = new ArrayList<>();

            for (int i = 0; i < N / 4; i++) {
                if (i != 0)
                    input = input.substring(input.length() - 1) + input.substring(0, input.length() - 1);

                int delta = 0;
                while (delta < input.length()) {
                    if (!list.contains(Integer.parseInt(input.substring(delta, delta + N / 4), 16)))
                        list.add(Integer.parseInt(input.substring(delta, delta + N / 4), 16));
                    delta += N / 4;
                }
            }

            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.intValue() - o1.intValue();
                }
            });

            System.out.println("#" + tc + " " + list.get(K - 1));
        }
    }
}
