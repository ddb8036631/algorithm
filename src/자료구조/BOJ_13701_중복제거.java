package 자료구조;

import java.util.BitSet;
import java.util.Scanner;

public class BOJ_13701_중복제거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splited = sc.nextLine().split(" ");
        BitSet bitSet = new BitSet();
        StringBuilder answer = new StringBuilder();

        for (String str : splited) {
            int num = Integer.parseInt(str);
            if (bitSet.get(num)) continue;

            bitSet.set(num);
            answer.append(num + " ");
        }

        System.out.println(answer);
    }
}
