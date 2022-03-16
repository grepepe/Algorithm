package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon16964 {

    private static final List<List<Integer>> adj = new ArrayList<>();
    private static int[] actualAns;
    private static boolean[] visit;
    private static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] expectedAns = new int[n + 1];
        int[] order = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            expectedAns[i] = Integer.parseInt(st.nextToken());
            order[expectedAns[i]] = i;
        }

        for (List<Integer> a : adj) {
            a.sort(Comparator.comparingInt(o -> order[o]));
        }

        actualAns = new int[n + 1];
        visit = new boolean[n + 1];

        visit[1] = true;
        dfs( 1);

        for (int i = 1; i <= n; i++) {
            if (expectedAns[i] != actualAns[i]) {
                System.out.print(0);
                return;
            }
        }
        System.out.print(1);
    }

    private static void dfs(int v) {
        actualAns[idx++] = v;
        for (int a : adj.get(v)) {
            if (!visit[a]) {
                visit[a] = true;
                dfs(a);
            }
        }
    }
}
