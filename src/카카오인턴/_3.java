package 카카오인턴;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _3 {
    public static String solution(int n, int k, String[] cmd) {
        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Deque<Integer> dead = new ArrayDeque<>();

        int rightDeadCnt = 0;

        for (int i = 0; i <= k; i++) left.push(i);
        for (int i = n - 1; i > k; i--) right.push(i);

        for (int i = 0; i < cmd.length; i++) {
            char[] arr = cmd[i].toCharArray();

            if (arr[0] == 'U') {
                int delta = arr[2] - '0';
                int cnt = 0;

                while (!left.isEmpty() && cnt < delta) {
                    if (alive[left.peek()]) cnt++;
                    else {
                        rightDeadCnt++;
                    }

                    right.push(left.pop());
                }

                while (!left.isEmpty() && !alive[left.peek()]) {
                    right.push(left.pop());
                    rightDeadCnt++;
                }

            } else if (arr[0] == 'D') {
                int delta = arr[2] - '0';
                int cnt = 0;

                while (!right.isEmpty() && cnt < delta) {
                    if (alive[right.peek()]) cnt++;
                    else {
                        rightDeadCnt--;
                    }

                    left.push(right.pop());
                }

                while (!right.isEmpty() && !alive[right.peek()]) {
                    left.push(right.pop());
                    rightDeadCnt--;
                }

            } else if (arr[0] == 'C') {
                alive[left.peek()] = false;
                dead.push(left.peek());

                if (rightDeadCnt == right.size()) {
                    while (!left.isEmpty() && !alive[left.peek()]) {
                        right.add(left.pop());
                        rightDeadCnt++;
                    }
                } else {
                    while (!right.isEmpty() && !alive[right.peek()]) {
                        left.add(right.pop());
                        rightDeadCnt--;
                    }

                    if (!right.isEmpty()) left.push(right.pop());
                }

            } else if (arr[0] == 'Z') {
                int idx = -1;

                if (!dead.isEmpty()) idx = dead.pop();

                if (idx != -1) {
                    alive[idx] = true;
                    if (right.contains(idx)) rightDeadCnt--;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (boolean flag : alive) {
            if (flag) sb.append("O");
            else sb.append("X");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }
}
