package 카카오2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

                if (f1_head.toString().compareTo(f2_head.toString()) > 0) return 1;
                else if (f1_head.toString().compareTo(f2_head.toString()) < 0) return -1;
                else {
                    int f1_number = makeNumber(f1, f1_idx);
                    int f2_number = makeNumber(f2, f2_idx);

                    if (f1_number > f2_number)  return 1;
                    else if (f1_number < f2_number)  return -1;
                    else return 0;
                }
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

    public static void main(String[] args) {
        solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
//        solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
//        solution(new String[]{"img-.0005.png", "im.g-5.png", "img.- 3.jpg", "im.g- 001.png"});
    }
}
