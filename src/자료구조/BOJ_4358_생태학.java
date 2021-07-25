package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class BOJ_4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        TreeSet<String> set = new TreeSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int totalCnt = 0;

        while ((input = br.readLine()) != null && input.length() > 0) {
            totalCnt++;
            set.add(input);
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        for (String name : set) {
            System.out.printf("%s %.4f\n", name, (double) map.get(name) / totalCnt * 100);
        }
    }
}
