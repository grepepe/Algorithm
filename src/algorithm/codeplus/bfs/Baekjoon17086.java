package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon17086 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<int[]> sharks = new ArrayList<>();
        final int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = 0;
                    q.offer(new int[]{i, j, 1});
                    visit[i][j] = true;
                } else {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            for (int[] d : dir) {

                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr > -1 && nc > -1 && nr < n && nc < m && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr, nc, tmp[2] + 1});
                    if (map[nr][nc] > tmp[2]) {
                        map[nr][nc] = tmp[2];
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans < map[i][j]) {
                    ans = map[i][j];
                }
            }
        }
        System.out.print(ans);
    }
}
