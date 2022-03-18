package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        int ans = 0;

        visit[n] = true;
        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            int[] next = new int[3];

            if (tmp[0] == k) {
                ans = tmp[1];
                break;
            }

            next[0] = tmp[0] + 1;
            next[1] = tmp[0] - 1;
            next[2] = tmp[0] * 2;

            for (int ne : next) {
                if (ne > -1 && ne < visit.length && !visit[ne]) {
                    visit[ne] = true;
                    q.offer(new int[]{ne, tmp[1] + 1});
                }
            }
        }

        System.out.print(ans);

    }
}
