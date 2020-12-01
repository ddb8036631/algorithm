package 프로그래머스_Level2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];

            if (hashMap.containsKey(key))
                hashMap.put(key, hashMap.get(key) + 1);
            else
                hashMap.put(key, 1);
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }
}
