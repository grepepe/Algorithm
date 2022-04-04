package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16236 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] start = new int[2];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        int sharkSize = 2;
        int eatNum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] > o2[2]) {
                return 1;
            } else if (o1[2] < o2[2]) {
                return -1;
            } else {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });
        final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(true){

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visit = new boolean[n][n];

            visit[start[0]][start[1]] = true;
            q.offer(new int[]{start[0], start[1], 0});

            while (!q.isEmpty()) {

                int[] tmp = q.poll();

                if (map[tmp[0]][tmp[1]] < sharkSize && map[tmp[0]][tmp[1]] != 0) {
                    pq.offer(tmp);
                }

                for (int[] d : dir) {

                    int nr = tmp[0] + d[0];
                    int nc = tmp[1] + d[1];

                    if (nr > -1 && nr < n && nc > -1 && nc < n && !visit[nr][nc] && map[nr][nc] <= sharkSize) {
                        visit[nr][nc] = true;
                        q.offer(new int[]{nr, nc, tmp[2] + 1});
                    }
                }
            }

            if (pq.isEmpty()) {
                break;
            }

            int[] tmp = pq.poll();

            start[0] = tmp[0];
            start[1] = tmp[1];
            map[start[0]][start[1]] = 0;
            eatNum++;
            if (sharkSize == eatNum) {
                eatNum = 0;
                sharkSize++;
            }
            pq.clear();
            ans += tmp[2];
        }

        System.out.print(ans);
    }
}
