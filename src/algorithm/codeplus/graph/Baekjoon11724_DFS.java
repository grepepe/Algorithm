package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon11724_DFS {

    private static final List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] visit;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            adj.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            adj.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i);
                ans++;
            }
        }

        System.out.print(ans);
    }

    private static void dfs(int idx) {
        for (int next : adj.get(idx)) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next);
            }
        }
    }
}
