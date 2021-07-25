package 구현;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] arr = new String[3];
        arr[0] = "This";
        arr[1] = "is";
        arr[2] = "JavaScript";

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
