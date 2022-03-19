package algorithm.codeplus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1991 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        CharTree tree = new CharTree();
        List<char[]> nodeInfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            nodeInfo.add(new char[]{st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }

        for (char[] ni : nodeInfo) {
            tree.addNode(ni[0]);
        }

        for (char[] ni : nodeInfo) {
            if (ni[1] != '.') {
                tree.addLeft(ni[0], ni[1]);
            }
            if (ni[2] != '.') {
                tree.addRight(ni[0], ni[2]);
            }
        }

        ans.append(tree.preOrder('A')).append("\n");
        ans.append(tree.inOrder('A')).append("\n");
        ans.append(tree.postOrder('A'));

        System.out.print(ans);
    }

    private static class CharTree {

        private final Map<Character, CharNode> nodeList;

        public CharTree() {
            this.nodeList = new HashMap<>();
        }

        public void addNode(char c) {
            this.nodeList.put(c, new CharNode(c));
        }

        public void addLeft(char parent, char child) {
            this.nodeList.get(parent).setLeft(this.nodeList.get(child));
        }

        public void addRight(char parent, char child) {
            this.nodeList.get(parent).setRight(this.nodeList.get(child));
        }

        public StringBuilder preOrder(char c) {

            StringBuilder sb = new StringBuilder();
            CharNode left = nodeList.get(c).getLeft();
            CharNode right = nodeList.get(c).getRight();

            sb.append(c);
            if (left != null) {
                sb.append(preOrder(left.getValue()));
            }
            if (right != null) {
                sb.append(preOrder(right.getValue()));
            }

            return sb;
        }

        public StringBuilder inOrder(char c) {

            StringBuilder sb = new StringBuilder();
            CharNode left = nodeList.get(c).getLeft();
            CharNode right = nodeList.get(c).getRight();

            if (left != null) {
                sb.append(inOrder(left.getValue()));
            }
            sb.append(c);
            if (right != null) {
                sb.append(inOrder(right.getValue()));
            }

            return sb;
        }

        public StringBuilder postOrder(char c) {

            StringBuilder sb = new StringBuilder();
            CharNode left = nodeList.get(c).getLeft();
            CharNode right = nodeList.get(c).getRight();

            if (left != null) {
                sb.append(postOrder(left.getValue()));
            }
            if (right != null) {
                sb.append(postOrder(right.getValue()));
            }
            sb.append(c);

            return sb;
        }

        private static class CharNode {

            private final char value;
            private CharNode left;
            private CharNode right;

            public CharNode(char value) {
                this.value = value;
            }

            public char getValue() {
                return value;
            }

            public CharNode getLeft() {
                return left;
            }

            public void setLeft(CharNode left) {
                this.left = left;
            }

            public CharNode getRight() {
                return right;
            }

            public void setRight(CharNode right) {
                this.right = right;
            }
        }
    }
}
