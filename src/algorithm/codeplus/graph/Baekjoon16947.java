package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16947 {

    private static int n;
    private static final List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] cycleStation;
    private static int start;
    private static boolean isFound = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        cycleStation = new boolean[n + 1];
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

        for (int i = 1; i <= n; i++) {
            if (cycleStation[i]) {
                sb.append(0).append(" ");
            } else {
                sb.append(bfs(i)).append(" ");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static int bfs(int idx) {

        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        q.offer(new int[]{idx, 0});
        visit[idx] = true;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (cycleStation[tmp[0]]) {
                return tmp[1];
            }

            for (int a : adj.get(tmp[0])) {
                if (!visit[a]) {
                    visit[a] = true;
                    q.offer(new int[]{a, tmp[1] + 1});
                }
            }
        }

        return 0;
    }

    private static void dfs(int idx, int cnt) {
        if (cnt > 2 && idx == start) {
            cycleStation[idx] = true;
            isFound = true;
            return;
        }
        for (int a : adj.get(idx)) {
            if (!cycleStation[a]) {
                cycleStation[a] = true;
                dfs(a, cnt + 1);
                if (isFound) {
                    return;
                }
                cycleStation[a] = false;
            }
        }
    }
}
