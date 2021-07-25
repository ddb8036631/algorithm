package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_10825_국영수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (Student student : list) {
            sb.append(student.name);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean, english, math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean == o.korean) {
                if (this.english == o.english) {
                    if (this.math == o.math) {
                        return name.compareTo(o.name);
                    } else {
                        return Integer.compare(o.math, this.math);
                    }
                } else {
                    return Integer.compare(this.english, o.english);
                }
            } else {
                return Integer.compare(o.korean, this.korean);
            }
        }
    }
}
