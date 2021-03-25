package 수학;

import java.util.Scanner;

public class BOJ_1193_분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int now = 1, next = 3, delta = 3, idx = 1;
        int A, B;

        while (true) {
            if (X == now) {
                if (idx % 2 == 0) { A = idx; B = 1; }
                else { A = 1; B = idx; }

                break;
            }

            if(X > now && X < next) {
                if(idx % 2 == 0) { A = next - X + 1; B = X - now; }
                else { A =X - now; B = next - X + 1; }

                break;
            }

            else {
                now = next;
                next = now + delta;
                delta++; idx++;
            }
        }

        System.out.println(A + "/" + B);
    }
}
