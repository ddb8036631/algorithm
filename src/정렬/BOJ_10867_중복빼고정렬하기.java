package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class BOJ_10867_중복빼고정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(e -> treeSet.add(e));

        StringBuilder sb = new StringBuilder();
        for (int num : treeSet) sb.append(num + " ");

        System.out.println(sb);
    }
}
