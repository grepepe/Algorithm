package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon11724_BFS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            adj.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            adj.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        Queue<Integer> q = new LinkedList<>();


        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {

                q.offer(i);
                visit[i] = true;

                while (!q.isEmpty()) {
                    for (int next : adj.get(q.poll())) {
                        if (!visit[next]) {
                            visit[next] = true;
                            q.offer(next);
                        }
                    }
                }

                ans++;
            }
        }

        System.out.print(ans);
    }
}
