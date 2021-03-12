package 카카오2020;

public class 문자열압축 {
    public static int solution(String s) {
        int answer = s.length();

        for (int delta = 1; delta < s.length(); delta++) {
            StringBuffer sb = new StringBuffer();

            int start = 0, end = 0 + delta;

            while (start != end && end <= s.length()) {
                String splited = s.substring(start, end);

                if (sb.length() == 0) {
                    sb.append(splited);
                } else {
                    String prev = sb.substring(sb.length() - delta, sb.length());

                    if (prev.length() != 0 && prev.equals(splited)) {
                        int countIndexEnd = sb.length() - delta - 1;

                        if (countIndexEnd >= 0) {
                            if (Character.isDigit(sb.charAt(countIndexEnd))) {
                                int countIndexStart = countIndexEnd - 1;

                                while (countIndexStart >= 0 && Character.isDigit(sb.charAt(countIndexStart)))
                                    countIndexStart--;
                                countIndexStart++;

                                int count = Integer.parseInt(sb.substring(countIndexStart, countIndexEnd + 1));

                                sb.replace(countIndexStart, countIndexEnd + 1, Integer.toString(count + 1));
                            } else {
                                sb.insert(countIndexEnd + 1, "2");
                            }
                        } else {
                            sb.insert(0, "2");
                        }
                    } else {
                        sb.append(splited);
                    }
                }

                start = end;
                end = ((start + delta) > s.length()) ? s.length() : start + delta;
            }

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("aabbaccc");
//        solution("ababcdcdababcdcd");
//        solution("abcabcdede");
//        solution("abcabcabcabcdededededede");
//        solution("xababcdcdababcdcd");
//        solution("xxxxxxxxxxyyy");
    }
}
