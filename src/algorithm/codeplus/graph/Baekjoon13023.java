package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon13023 {

    private static final List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] visit;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            adj.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            adj.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        for (int i = 0; i < n; i++) {
            if (ans == 1) {
                break;
            }
            visit[i] = true;
            dfs(i, 1);
            visit[i] = false;
        }

        System.out.print(ans);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == 5) {
            ans = 1;
            return;
        }

        for (int next : adj.get(idx)) {
            if (ans == 1) {
                break;
            }
            if (!visit[next]) {
                visit[next] = true;
                dfs(next, cnt + 1);
                visit[next] = false;
            }
        }
    }
}
