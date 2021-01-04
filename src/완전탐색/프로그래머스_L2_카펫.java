package 완전탐색;

public class 프로그래머스_L2_카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        int i = 3;
        while (true) {
            if (sum % i != 0) {
                i++;
                continue;
            }

            int column = i; // 세로
            int row = sum / i; // 가로

            if (column > row) break;

            int b = (row + column) * 2 - 4;
            int y = sum - b;

            if (b == brown && y == yellow) {
                answer[0] = row;
                answer[1] = column;

                break;
            }

            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        int brown = 10;
//        int yellow = 2;

//        int brown = 8;
//        int yellow = 1;

        int brown = 24;
        int yellow = 24;

        solution(brown, yellow);
    }
}
