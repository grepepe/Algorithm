package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16928 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nm = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int[] move = new int[101];
        int ans = 0;

        for (int i = 1; i < move.length; i++) {
            move[i] = i;
        }

        for (int i = 0; i < nm; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visit = new boolean[101];

        visit[1] = true;
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {

            int[] tmp = pq.poll();

            if (tmp[0] == 100) {
                ans = tmp[1];
                break;
            }

            for (int i = 6; i > 0; i--) {

                int next = tmp[0] + i;

                if (next < 101 && !visit[move[next]]) {
                    visit[move[next]] = true;
                    pq.offer(new int[]{move[next], tmp[1] + 1});
                }
            }
        }

        System.out.print(ans);
    }
}
