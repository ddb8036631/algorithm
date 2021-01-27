package 카카오2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 파일명정렬 {
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        ArrayList<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(new File(files[i].toUpperCase(), i));
        }

        Comparator comp = new Comparator<File>() {

            @Override
            public int compare(File f1, File f2) {
                StringBuffer f1_head = makeHead(f1);
                StringBuffer f2_head = makeHead(f2);

                int f1_idx = f1_head.length(), f2_idx = f2_head.length();

                if (!f1_head.toString().equals(f2_head.toString()))
                    return f1_head.toString().compareTo(f2_head.toString());

                int f1_number = makeNumber(f1, f1_idx);
                int f2_number = makeNumber(f2, f2_idx);

                return Integer.compare(f1_number, f2_number);
            }
        };

        Collections.sort(list, comp);

        for (int i = 0; i < list.size(); i++) {
            File file = list.get(i);
            answer[i] = files[file.index];
        }

        return answer;
    }

    private static StringBuffer makeHead(File file) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < file.fileName.length(); i++) {
            char c = file.fileName.charAt(i);
            if (Character.isDigit(c)) break;
            sb.append(c);
        }

        return sb;
    }

    private static int makeNumber(File file, int index) {
        StringBuffer sb = new StringBuffer();

        while (index < file.fileName.length() && Character.isDigit(file.fileName.charAt(index))) {
            sb.append(file.fileName.charAt(index));
            index++;
        }

        return Integer.parseInt(sb.toString());
    }

    private static class File {
        String fileName;
        int index;

        public File(String fileName, int index) {
            this.fileName = fileName;
            this.index = index;
        }
    }

    public static String[] solution2(String[] files) {
        Pattern pattern = Pattern.compile("(?<HEAD>\\D+)(?<NUMBER>\\d+)(?<TAIL>.*)");

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Matcher matcher1 = pattern.matcher(o1.toLowerCase());
                Matcher matcher2 = pattern.matcher(o2.toLowerCase());

                matcher1.find();
                matcher2.find();

                System.out.println(matcher1.group("HEAD"));
                System.out.println(matcher2.group("HEAD"));

                if(!matcher1.group("HEAD").equals(matcher2.group("HEAD")))
                    return matcher1.group("HEAD").compareTo(matcher2.group("HEAD"));

                int n1 = Integer.parseInt(matcher1.group("NUMBER"));
                int n2 = Integer.parseInt(matcher2.group("NUMBER"));

                return n1 == n2 ? 0 : Integer.compare(n1, n2);
            }
        });

        return files;
    }

    public static void main(String[] args) {
        solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
//        solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
//        solution(new String[]{"img-.0005.png", "im.g-5.png", "img.- 3.jpg", "im.g- 001.png"});
    }
}
