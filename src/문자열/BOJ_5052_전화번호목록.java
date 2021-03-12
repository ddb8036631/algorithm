package 문자열;

import java.util.Scanner;

public class BOJ_5052_전화번호목록 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            boolean answer = true;
            Trie trie = new Trie();

            int n = sc.nextInt();
            String[] inputs = new String[n];

            for (int i = 0; i < n; i++) {
                trie.insert(inputs[i] = sc.next());
            }

            for (String input : inputs) {
                if (!trie.find(input)) {
                    answer = false;
                    break;
                }
            }

            System.out.println(answer ? "YES" : "NO");
        }
    }

    private static class Trie {
        TrieNode root = new TrieNode();

        private void insert(String str) {
            TrieNode current = root;
            int len = str.length();

            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                int idx = ctoi(ch);

                if (current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                    current.childCnt++;
                }

                current.children[idx].value = ch;
                current = current.children[idx];
            }

            current.isTerminal = true;
        }

        private boolean find(String str) {
            TrieNode current = root;
            int len = str.length();

            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                int idx = ctoi(ch);
                current = current.children[idx];
            }

            return current != null && current.isTerminal && current.childCnt == 0;
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[10];
        char value;
        boolean isTerminal;
        int childCnt;
    }

    private static int ctoi(char ch) {
        return ch - '0';
    }
}
