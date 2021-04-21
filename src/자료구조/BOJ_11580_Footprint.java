package 자료구조;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_11580_Footprint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String command = sc.next();

        HashSet<Point> set = new HashSet<>();
        int x = 0, y = 0;

        for (int j = 0; j < L; j++) {
            switch (command.charAt(j)) {
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
                case 'S':
                    x--;
                    break;
                case 'N':
                    x++;
                    break;
            }

            set.add(new Point(x, y));
        }

        System.out.println(set.size());
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return (x + y + "").hashCode();
        }
    }
}
