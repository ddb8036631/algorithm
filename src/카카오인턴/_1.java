package 카카오인턴;

public class _1 {
    public static int solution(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < arr.length) {
            if (arr[idx] - '0' >= 0 && arr[idx] - '0' <= 9) {
                sb.append(arr[idx]);
                idx++;
                continue;
            }

            if (arr[idx] == 'z') {
                sb.append("0");
                idx += 4;
            } else if (arr[idx] == 'o') {
                sb.append("1");
                idx += 3;
            } else if (arr[idx] == 't') {
                if (arr[idx + 1] == 'w') {
                    sb.append("2");
                    idx += 3;
                } else {
                    sb.append("3");
                    idx += 5;
                }
            } else if (arr[idx] == 'f') {
                if (arr[idx + 1] == 'o') {
                    sb.append("4");
                    idx += 4;
                } else {
                    sb.append("5");
                    idx += 4;
                }
            } else if (arr[idx] == 's') {
                if (arr[idx + 1] == 'i') {
                    sb.append("6");
                    idx += 3;
                } else {
                    sb.append("7");
                    idx += 5;
                }
            } else if (arr[idx] == 'e') {
                sb.append("8");
                idx += 5;
            } else {
                sb.append("9");
                idx += 4;
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }
}
