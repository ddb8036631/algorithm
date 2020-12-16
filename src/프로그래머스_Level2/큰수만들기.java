package 프로그래머스_Level2;

public class 큰수만들기 {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        int K = k;
        for (k = 0; k < K; k++) {
            int target = sb.length() - 1;
            for (int idx = 0; idx < sb.length() - 1; idx++) {
                if (sb.charAt(idx) < sb.charAt(idx + 1)) {
                    target = idx;
                    break;
                }
            }

            sb.deleteCharAt(target);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
//        String number = "1231234";
//        int k =3;
//        String number = "4177252841";
//        int k =4;

        System.out.println(solution(number, k));

    }
}
