package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 {

    private static List<List<Integer>> adj;
    private static boolean[] visit;
    private static final StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        visit = new boolean[n+1];
        adj = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            adj.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            adj.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(adj.get(i));
        }

        visit[v] = true;
        ans.append(v).append(" ");
        dfs(v);
        ans.deleteCharAt(ans.length() - 1).append("\n");

        visit = new boolean[n+1];
        bfs(v);
        ans.deleteCharAt(ans.length() - 1);

        System.out.print(ans);
    }

    private static void bfs(int v) {

        Queue<Integer> q = new LinkedList<>();
        int idx;

        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()) {

            idx = q.poll();
            ans.append(idx).append(" ");

            for (int next : adj.get(idx)) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    private static void dfs(int v) {
        for (int next : adj.get(v)) {
            if (!visit[next]) {
                visit[next] = true;
                ans.append(next).append(" ");
                dfs(next);
            }
        }
    }
}
