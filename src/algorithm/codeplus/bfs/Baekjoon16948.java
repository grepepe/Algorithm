package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16948 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] start = new int[2];
        int[] end = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = -1;

        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        final int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

        visit[start[0]][start[1]] = true;
        q.offer(new int[]{start[0], start[1], 0});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == end[0] && tmp[1] == end[1]) {
                ans = tmp[2];
                break;
            }

            for (int[] d : dir) {

                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr > -1 && nr < n && nc > -1 && nc < n && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr, nc, tmp[2] + 1});
                }
            }
        }

        System.out.print(ans);
    }
}
