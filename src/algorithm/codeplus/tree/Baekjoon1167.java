package algorithm.codeplus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon1167 {

    private static final List<List<int[]>> tree = new ArrayList<>();
    private static boolean[] visit;
    private static int node = 1;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {

            String[] input = br.readLine().split(" ");
            int[] tmp = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            for (int j = 1; j < tmp.length - 1; j += 2) {
                tree.get(tmp[0]).add(new int[]{tmp[j], tmp[j + 1]});
            }
        }

        for (int i = 0; i < 2; i++) {
            visit = new boolean[v + 1];
            visit[node] = true;
            dfs(node, 0);
        }

        System.out.print(ans);
    }

    private static void dfs(int next, int dis) {

        boolean isLeaf = true;

        for (int[] t : tree.get(next)) {
            if (!visit[t[0]]) {
                isLeaf = false;
                visit[t[0]] = true;
                dfs(t[0], dis + t[1]);
            }
        }

        if (isLeaf && ans < dis) {
            node = next;
            ans = dis;
        }
    }
}
