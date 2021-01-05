package 동적계획법;

public class 프로그래머스_L4_도둑질 {
    public static int solution(int[] money) {
        int answer = 0;

        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < money.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
        }

        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);

        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

//        for (int i = 0; i < money.length; i++) {
//            answer = Math.max(answer, dp1[i]);
//            answer = Math.max(answer, dp2[i]);
//        }

        answer = Math.max(answer, dp1[money.length - 1]);
        answer = Math.max(answer, dp1[money.length - 1]);


        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
//        int[] money = {1, 2, 3, 3, 2, 1};
//        int[] money = {1, 2, 3, 1};
//        int[] money = {1, 2, 3, 3, 2, 1, 1};
//        int[] money = {2, 1, 3, 4, 1};


        solution(money);
    }
}
