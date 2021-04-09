package 동적계획법;

public class Test {
    public static void main(String[] args) {
        int[][] map = new int[10][10];
        int cnt = 1;

        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 5) break outer;

                map[i][j] = cnt++;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%2d ", map[i][j]);
            }
            System.out.println();
        }
    }
}
