package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16947 {

    private static int n;
    private static final List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] visit;
    private static int start;
    private static boolean isFound = false;
    private static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        ans = new int[n + 1];
        String input;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while ((input = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adj.get(i));
        }

        for (int i = 1; i <= n; i++) {
            start = i;
            dfs(i, 0);
            if (isFound) {
                break;
            }
        }

        bfs();

        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (visit[i]) {
                q.offer(new int[]{i, 0});
            }
        }

        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            ans[tmp[0]] = tmp[1];

            for (int a : adj.get(tmp[0])) {
                if (!visit[a]) {
                    visit[a] = true;
                    q.offer(new int[]{a, tmp[1] + 1});
                }
            }
        }

    }

    private static void dfs(int idx, int cnt) {
        if (cnt > 2 && idx == start) {
            visit[idx] = true;
            isFound = true;
            return;
        }
        for (int a : adj.get(idx)) {
            if (!visit[a]) {
                visit[a] = true;
                dfs(a, cnt + 1);
                if (isFound) {
                    return;
                }
                visit[a] = false;
            }
        }
    }
}
