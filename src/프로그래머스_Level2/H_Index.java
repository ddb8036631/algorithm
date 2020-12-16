package 프로그래머스_Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class H_Index {
    public static int solution(int[] citations) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int count : citations)
            list.add(count);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });

        int idx = 0;
        while (idx < list.size()) {
            if (list.get(idx) <= idx) break;
            idx++;
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {31, 66};
        System.out.println(solution(citations));
    }
}
