package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        StringTokenizer st;
        int[] order = new int[n + 1];
        int[] expectedAns = new int[n + 1];
        int[] actualAns = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>(8));
        }

        for (int i = 1; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());


        for (int i = 1; i <= n; i++) {
            expectedAns[i] = Integer.parseInt(st.nextToken());
            order[expectedAns[i]] = i;
        }

        for (List<Integer> a : adj) {
            a.sort(Comparator.comparingInt(o -> order[o]));
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        int idx = 1;

        q.offer(1);
        visit[1] = true;

        while (!q.isEmpty()) {

            int tmp = q.poll();
            actualAns[idx++] = tmp;

            for (int a : adj.get(tmp)) {
                if (!visit[a]) {
                    q.offer(a);
                    visit[a] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (expectedAns[i] != actualAns[i]) {
                System.out.print(0);
                return;
            }
        }
        System.out.print(1);
    }
}
