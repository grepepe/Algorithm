package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon1707 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] input;
        int v, e;
        List<List<Integer>> adj;
        int[] visit;
        StringBuilder ans = new StringBuilder();

        while (k-- > 0) {

            input = br.readLine().split(" ");
            v = Integer.parseInt(input[0]);
            e = Integer.parseInt(input[1]);
            adj = new ArrayList<>();
            visit = new int[v + 1];

            for (int i = 0; i <= v; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {

                input = br.readLine().split(" ");

                int v1 = Integer.parseInt(input[0]);
                int v2 = Integer.parseInt(input[1]);

                adj.get(v1).add(v2);
                adj.get(v2).add(v1);
            }

            for (int i = 1; i <= v; i++) {
                if (visit[i] == 0) {
                    dfs(adj, visit, i);
                }
            }

            if (isBipartite(adj, visit)) {
                ans.append("YES").append("\n");
            } else {
                ans.append("NO").append("\n");
            }
        }

        ans.deleteCharAt(ans.length() - 1);
        System.out.print(ans);
    }

    private static boolean isBipartite(List<List<Integer>> adj, int[] visit) {
        for (int i = 1; i < adj.size(); i++) {
            for (int next : adj.get(i)) {
                if (visit[i] == visit[next]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> adj, int[] visit, int idx) {

        Queue<int[]> q = new LinkedList<>();
        int color = 1;

        q.offer(new int[]{idx, color});
        visit[idx] = color;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            color = tmp[1] == 1 ? 2 : 1;

            for (int next : adj.get(tmp[0])) {
                if (visit[next] == 0) {
                    visit[next] = color;
                    q.offer(new int[]{next, color});
                }
            }
        }
    }
}
