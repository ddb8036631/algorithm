package 카카오2019;

import java.util.ArrayList;
import java.util.Arrays;

public class 매칭점수 {
    public static int solution(String word, String[] pages) {
        int answer = 0;

        Info[] infos = new Info[pages.length];
        for (int i = 0; i < infos.length; i++) {
            infos[i] = new Info(i);
        }

        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];

            setUrl(infos, i, page);
            setExternalLinks(infos, i, page);
            setBasicScore(infos, i, page, word);
        }

        for (int i = 0; i < infos.length; i++) {
            double total = 0;
            for (int j = 0; j < infos.length; j++) {
                if (i == j) continue;

                if (infos[j].externalLinks.contains(infos[i].url)) {
                    total += (double) infos[j].basicScore / infos[j].externalLinkCnt;
                }
            }

            infos[i].linkScore = total;
            infos[i].matchingScore = infos[i].basicScore + infos[i].linkScore;
        }

        Arrays.sort(infos);

        answer = infos[0].index;

        return answer;
    }

    static void setUrl(Info[] infos, int index, String page) {
        String search = "<meta property=\"og:url\" content=\"";
        int url_start_idx = page.indexOf(search) + search.length();
        int url_end_idx = url_start_idx + page.substring(url_start_idx).indexOf("\"/>");

        String url = page.substring(url_start_idx, url_end_idx);

        infos[index].url = url;
    }

    static void setExternalLinks(Info[] infos, int index, String page) {
        ArrayList<String> externalLinks = new ArrayList<>();
        String search = "<a href=\"";
        String tmp = page;

        while (tmp.indexOf(search) != -1) {
            int a_start_idx = tmp.indexOf(search) + search.length();
            int a_end_idx = a_start_idx + tmp.substring(a_start_idx).indexOf("\">");

            String externalLink = tmp.substring(a_start_idx, a_end_idx);
            externalLinks.add(externalLink);

            tmp = tmp.substring(a_end_idx);
        }
        infos[index].externalLinks = externalLinks;
        infos[index].externalLinkCnt = externalLinks.size();
    }

    static void setBasicScore(Info[] infos, int index, String page, String word) {
        String search = "<body>";
        int body_start_idx = page.indexOf(search) + search.length();
        int body_end_idx = body_start_idx + page.substring(body_start_idx).indexOf("</body>");

        String body = page.substring(body_start_idx, body_end_idx).toUpperCase();
        body = body.toUpperCase();
        word = word.toUpperCase();

        int cnt = 0;
        int find = body.indexOf(word);

        while (find != -1) {
            char prev = body.charAt(find - 1);
            char next = body.charAt(find + word.length());

            if (!Character.isLetter(prev) && !Character.isLetter(next)) {
                cnt++;
            }

            find = body.indexOf(word, find + 1);
        }

        infos[index].basicScore = cnt;
    }

    static class Info implements Comparable<Info> {
        String url;
        ArrayList<String> externalLinks;
        int index, basicScore, externalLinkCnt;
        double linkScore, matchingScore;

        public Info(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(Info o) {
            return this.matchingScore == o.matchingScore ? this.index - o.index : Double.compare(o.matchingScore, this.matchingScore);
        }
    }

    public static void main(String[] args) {
//        solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"});
        solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});
    }
}
