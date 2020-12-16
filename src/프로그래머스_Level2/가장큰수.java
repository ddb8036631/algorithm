package 프로그래머스_Level2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (arr[0].equals("0"))
            return "0";

        for (String s : arr)
            answer += s;

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {12, 121};
//        int[] numbers= {0, 0, 0};

        System.out.println(solution(numbers));
    }
}
