package algorithm.codeplus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2250 {

    private static int n;
    private static int idx = 1;
    private static List<Node> tree;
    private static List<Integer> min;
    private static List<Integer> max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>(n+1);
        min = new ArrayList<>();
        max = new ArrayList<>();
        boolean[] isChild = new boolean[n+1];
        int level = 0;
        int width = 0;

        for (int i = 0; i <= n; i++) {
            tree.add(new Node());
        }

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt((st.nextToken()));
            int child1 = Integer.parseInt((st.nextToken()));
            int child2 = Integer.parseInt((st.nextToken()));

            tree.get(parent).setLeft(child1);
            tree.get(parent).setRight(child2);

            if (child1 != -1) {
                isChild[child1] = true;
            }
            if (child2 != -1) {
                isChild[child2] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!isChild[i]) {
                dfs(i, 1);
                break;
            }
        }

        for (int i = 1; i < min.size(); i++) {

            int tmp = max.get(i) - min.get(i) + 1;

            if (width < tmp) {
                level = i;
                width = tmp;
            }
        }

        System.out.print(level + " " + width);
    }

    private static void dfs(int node, int level) {

        int left = tree.get(node).getLeft();
        int right = tree.get(node).getRight();

        if (left != -1) {
            dfs(left, level+1);
        }

        while (min.size() <= level) {
            min.add(n);
        }
        min.set(level, Math.min(min.get(level), idx));

        while (max.size() <= level) {
            max.add(0);
        }
        max.set(level, idx++);

        if (right != -1) {
            dfs(right, level+1);
        }
    }

    private static class Node {

        private int left;
        private int right;

        public Node() {
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}
