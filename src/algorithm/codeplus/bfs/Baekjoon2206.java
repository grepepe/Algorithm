package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2206 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];
        final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = -1;

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visit = new boolean[n][m][2];

        visit[0][0][1] = true;
        q.offer(new int[]{0, 0, 1, 1});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == n - 1 && tmp[1] == m - 1) {
                ans = tmp[2];
                break;
            }

            for (int[] d : dir) {

                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr > -1 && nr < n && nc > -1 && nc < m && !visit[nr][nc][tmp[3]]) {
                    if (!map[nr][nc]) {
                        visit[nr][nc][tmp[3]] = true;
                        q.offer(new int[]{nr, nc, tmp[2] + 1, tmp[3]});
                    } else if (tmp[3] == 1) {
                        visit[nr][nc][0] = true;
                        q.offer(new int[]{nr, nc, tmp[2] + 1, 0});
                    }
                }
            }
        }

        System.out.print(ans);
    }
}
