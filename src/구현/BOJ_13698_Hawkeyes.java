package 구현;

import java.util.Scanner;

public class BOJ_13698_Hawkeyes {
    static int[] arr = {0, 1, 0, 0, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        for (int i = 0; i < input.length(); i++) {
            char command = input.charAt(i);

            switch (command) {
                case 'A':
                    swap(1, 2); break;
                case 'B':
                    swap(1, 3); break;
                case 'C':
                    swap(1, 4); break;
                case 'D':
                    swap(2, 3); break;
                case 'E':
                    swap(2, 4); break;
                case 'F':
                    swap(3, 4); break;
            }
        }

        int small = 0, large = 0;
        for (int i = 1; i <= 4; i++) {
            if (arr[i] == 1) small = i;
            else if (arr[i] == 2) large = i;
        }

        System.out.println(small + "\n" + large);
    }

    static void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
