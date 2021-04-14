package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_2870_수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("[\\d]+");

        while (N-- > 0) {
            String input = br.readLine();
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String num = matcher.group().replaceAll("^0+", "");
                numbers.add(num.length() == 0 ? "0" : num);
            }
        }

        numbers.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String num : numbers) sb.append(num + "\n");

        System.out.println(sb);
    }
}
