package 자료구조;

import java.util.*;

public class BOJ_5430_AC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            String ans = "";

            String p = sc.next();
            int n = sc.nextInt();
            String arr = sc.next();

            Deque<Integer> deque = new ArrayDeque<>();
            if (!arr.equals("[]")) {
                arr = arr.substring(1, arr.length() - 1);
                String[] splitArr = arr.split(",");
                if (splitArr.length != 0) {
                    for (String s : splitArr) {
                        deque.addLast(Integer.parseInt(s));
                    }
                }
            }

            boolean front = true;
            boolean wrong = false;
            int idx = 0;

            while (idx < p.length()) {
                if (p.charAt(idx) == 'R') {
                    front = !front;
                } else if (p.charAt(idx) == 'D') {
                    if (deque.isEmpty()) {
                        wrong = true;
                        break;
                    } else {
                        if (front) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                    }
                }

                idx++;
            }

            if (!deque.isEmpty()) {
                StringBuilder sb = new StringBuilder("[");

                Iterator<Integer> iter = front ? deque.iterator() : deque.descendingIterator();

                while (iter.hasNext()) {
                    sb.append(iter.next() + ",");
                }
                ans = sb.substring(0, sb.length() - 1) + "]";
            } else {
                ans = "[]";
            }

            if (wrong)
                ans = "error";

            System.out.println(ans);
        }
    }
}
