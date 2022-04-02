package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16933 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n + 1][m + 1];
        int ans = -1;

        for (int i = 1; i <= n; i++) {

            String input = br.readLine();

            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j - 1) == '1';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visit = new boolean[n + 1][m + 1][k + 1];
        final int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        visit[1][1][k] = true;
        q.offer(new int[]{1, 1, k, 0, 1});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == n && tmp[1] == m) {
                ans = tmp[4];
                break;
            }

            for (int[] d : dir) {

                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr > 0 && nr <= n && nc > 0 && nc <= m) {
                    if (map[nr][nc] && tmp[2] > 0) {
                        if (tmp[3] == 0 && !visit[nr][nc][tmp[2] - 1]) {
                            visit[nr][nc][tmp[2] - 1] = true;
                            q.offer(new int[]{nr, nc, tmp[2] - 1, 1, tmp[4] + 1});
                        } else if (tmp[3] == 1 && !visit[nr][nc][tmp[2]]) {
                            q.offer(new int[]{tmp[0], tmp[1], tmp[2], 0, tmp[4] + 1});
                        }
                    } else if (!map[nr][nc] && !visit[nr][nc][tmp[2]]) {
                        visit[nr][nc][tmp[2]] = true;
                        q.offer(new int[]{nr, nc, tmp[2], tmp[3] ^ 1, tmp[4] + 1});
                    }
                }
            }
        }

        System.out.print(ans);
    }
}