package algorithm.codeplus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11725 {

    private static final List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] visit;
    private static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        visit = new boolean[n + 1];
        ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        String input;

        while ((input = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            sb.append(ans[i]).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void dfs(int next) {
        for (int a : adj.get(next)) {
            if (!visit[a]) {
                visit[a] = true;
                ans[a] = next;
                dfs(a);
            }
        }
    }
}
