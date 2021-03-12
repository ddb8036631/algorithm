package 카카오2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 길찾기게임 {
    static int[][] answer = {};
    static int cnt;

    public static int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];

        ArrayList<Info> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Info(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.y == o2.y ? o1.x - o2.x : o2.y - o1.y;
            }
        });

        BinarySearchTree bst = new BinarySearchTree();
        for (Info info : list) {
            bst.insert(info.index, info.x);
        }

        bst.preorder(bst.root);

        cnt = 0;
        bst.postorder(bst.root);

        return answer;
    }

    static class Info {
        int index, x, y;

        public Info(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    static class TreeNode {
        int index;
        int x;
        TreeNode left;
        TreeNode right;

        public TreeNode(int index, int x) {
            this.index = index;
            this.x = x;
        }
    }

    static class BinarySearchTree {
        TreeNode root;

        void insert(int index, int x) {
            TreeNode newNode = new TreeNode(index, x);

            if (root == null) {
                root = newNode;
                return;
            }

            TreeNode current = root;
            TreeNode parent = null;

            while (true) {
                parent = current;

                if (x < current.x) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

        void preorder(TreeNode node) {
            if (node != null) answer[0][cnt++] = node.index;
            if (node.left != null) preorder(node.left);
            if (node.right != null) preorder(node.right);
        }

        void postorder(TreeNode node) {
            if (node.left != null) postorder(node.left);
            if (node.right != null) postorder(node.right);
            if (node != null) answer[1][cnt++] = node.index;
        }
    }

    public static void main(String[] args) {
        solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
    }
}
