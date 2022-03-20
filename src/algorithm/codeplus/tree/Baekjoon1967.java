package algorithm.codeplus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1967 {

    private static final List<List<int[]>> tree = new ArrayList<>();
    private static boolean[] visit;
    private static int node = 1;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmp = new int[3];

            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }

            tree.get(tmp[0]).add(new int[]{tmp[1], tmp[2]});
            tree.get(tmp[1]).add(new int[]{tmp[0], tmp[2]});
        }

        for (int i = 0; i < 2; i++) {
            visit = new boolean[n + 1];
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
