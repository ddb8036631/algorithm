package 카카오2018;

public class n진수게임 {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int count = 1;
        boolean exit = false;

        while (!exit) {
            String converted = convert(num++, n);

            for (char c : converted.toCharArray()) {
                if (t == 0) {
                    exit = true;
                    break;
                }

                if (count % m == p || (count % m == 0 && m == p)) {
                    answer += c;
                    t--;
                }

                count++;
            }
        }

        return answer;
    }

    public static String convert(int num, int radix) {
        if (num == 0) return "0";

        String converted = "";

        while (num > 0) {
            int quotient = num / radix;
            int remainder = num % radix;

            switch (remainder) {
                case 10:
                    converted = 'A' + converted; break;
                case 11:
                    converted = 'B' + converted; break;
                case 12:
                    converted = 'C' + converted; break;
                case 13:
                    converted = 'D' + converted; break;
                case 14:
                    converted = 'E' + converted; break;
                case 15:
                    converted = 'F' + converted; break;
                default:
                    converted = remainder + converted;
            }

            num = quotient;
        }

        return converted;
    }

    public static void main(String[] args) {
        solution(2, 4, 2, 1);
//        solution(16, 16, 2, 1);
//        solution(16, 16, 2, 2);
    }
}
