package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10825_국영수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        List<Student> list = new ArrayList<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
        }

        list.stream()
                .sorted(Comparator.comparing(Student::getKo).reversed()
                        .thenComparing(Student::getEn)
                        .thenComparing(Comparator.comparing(Student::getMath).reversed())
                        .thenComparing(Student::getName))
                .map(Student::getName)
                .forEach(System.out::println);
    }

    static class Student {
        String name;
        int ko, en, math;

        public Student(String name, int ko, int en, int math) {
            this.name = name;
            this.ko = ko;
            this.en = en;
            this.math = math;
        }

        public int getKo() { return ko; }
        public int getEn() { return en; }
        public int getMath() { return math; }
        public String getName() { return name; }
    }

    public static int stoi(String s) { return Integer.parseInt(s); }
}
