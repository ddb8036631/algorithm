package SWEA_D3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1230_암호문3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            List<String> list = new LinkedList<>();

            for (int i = 0; i < N; i++) list.add(sc.next());

            int M = sc.nextInt();

            for (int i = 0; i < M; i++) {
                String command = sc.next();

                if (command.equals("I")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    String[] tmp = new String[y];

                    for (int j = 0; j < y; j++) tmp[j] = sc.next();
                    for (int j = y - 1; j >= 0; j--) list.add(x, tmp[j]);
                } else if (command.equals("D")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    while (y-- > 0) list.remove(x);
                } else if (command.equals("A")) {
                    int y = sc.nextInt();

                    while (y-- > 0) list.add(sc.next());
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
