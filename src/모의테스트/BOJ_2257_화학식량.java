package 모의테스트;

import java.util.*;

public class BOJ_2257_화학식량 {
    static final int H = 1, C = 12, O = 16;
    static Deque<Integer> res;
    static Deque<Character> bracket;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        char[] str = sc.nextLine().replaceAll("\\(\\)", "").toCharArray();
        char[] str = sc.nextLine().toCharArray();
        res = new ArrayDeque<>();
        bracket = new ArrayDeque<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == ')') {
                accumulate();
            } else if (str[i] >= '2' && str[i] <= '9') {
                if (bracket.isEmpty()) {
                    int num = res.pop();
                    res.push(num * ctoi(str[i]));
                } else bracket.push(str[i]);
            } else if (str[i] == 'H' || str[i] == 'C' || str[i] == 'O')
                bracket.push(str[i]);
        }

        accumulate();
        while (!res.isEmpty()) answer += res.pop();
        System.out.println(answer);
    }

    static int ctoi(char c) {
        return c - '0';
    }

    static void accumulate() {
        int delta = 1;
        int before = 0;
        ArrayList<Integer> tmp = new ArrayList<>();

        while (!bracket.isEmpty()) {
            char ch = bracket.pop();

            if (ch >= '2' && ch <= '9') {
                delta = ctoi(ch);
            } else {
                if (ch == 'H') before = H;
                else if (ch == 'C') before = C;
                else before = O;

                tmp.add(before * delta);
                delta = 1;
            }
        }

        int sum = 0;
        for (int num : tmp) sum += num;

        if (sum != 0) res.push(sum);
    }
}

// (H)(O)(2)
// (H)()()()(3)