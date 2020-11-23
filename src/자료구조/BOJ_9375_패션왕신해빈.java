package 자료구조;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_9375_패션왕신해빈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int n = 0; n < N; n++) {
                String[] s = sc.nextLine().split(" ");

                if (!hashMap.containsKey(s[1])) {
                    hashMap.put(s[1], 1);
                } else {
                    int cnt = hashMap.get(s[1]);
                    hashMap.remove(s[1]);
                    hashMap.put(s[1], cnt + 1);
                }
            }

            int result = 1;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                result *= entry.getValue() + 1;
            }

            System.out.println(result - 1);
        }
    }
}
