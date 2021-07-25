package 수학;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1049_기타줄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Pair> eachIncreasing = new ArrayList<>();
        ArrayList<Pair> setIncreasing = new ArrayList<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            Pair p = new Pair(sc.nextInt(), sc.nextInt());
            setIncreasing.add(p);
            eachIncreasing.add(p);
        }

        eachIncreasing.sort((p1, p2) -> p1.each - p2.each);
        setIncreasing.sort((p1, p2) -> p1.set - p2.set);

        int minEach = eachIncreasing.get(0).each;
        int minSet = setIncreasing.get(0).set;

        answer = Math.min(answer, minEach * N);
        answer = Math.min(answer, minSet * (N / 6) + minEach * (N % 6));
        answer = Math.min(answer, minSet * (N / 6 + 1));

        System.out.println(answer);
    }

    static class Pair {
        int set, each;

        public Pair(int set, int each) {
            this.set = set;
            this.each = each;
        }
    }
}
