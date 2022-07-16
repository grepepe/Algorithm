package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon17089 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        br.close();

        int ans = 3 * n;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (adj.get(i).contains(j)) {
                    for (int k = j + 1; k <= n; k++) {
                        if (adj.get(j).contains(k) && adj.get(k).contains(i)) {
                            ans = Math.min(ans, adj.get(i).size() + adj.get(j).size() + adj.get(k).size() - 6);
                        }
                    }
                }
            }
        }

        System.out.print(ans == 3 * n ? -1 : ans);
    }
}
