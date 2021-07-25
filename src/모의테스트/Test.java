package 모의테스트;

public class Test {
    public static void main(String[] args) {
        int n = 0;
        int diff = Integer.MAX_VALUE;

        while (n * n < diff) {
            System.out.println(n);
            n++;
        }

        System.out.println(n);
    }
}