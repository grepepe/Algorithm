package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5014 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int[] dis = new int[2];

        dis[0] = Integer.parseInt(st.nextToken());
        dis[1] = -Integer.parseInt(st.nextToken());
        br.close();

        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[f + 1];

        q.offer(new int[]{s, 0});
        visit[s] = true;

        int ans = -1;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == g) {
                ans = tmp[1];
                break;
            }

            for (int d : dis) {

                int ns = tmp[0] + d;

                if (ns >= 1 && ns <= f && !visit[ns]) {
                    visit[ns] = true;
                    q.offer(new int[]{ns, tmp[1] + 1});
                }
            }
        }

        System.out.print(ans == -1 ? "use the stairs" : ans);
    }
}
