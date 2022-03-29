package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14502 {

    private static int n, m;
    private static int[][] map;
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.print(ans);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt > 2) {
            bfs();
            return;
        }
        for (int i = idx; i < n * m; i++) {

            int r = i / m;
            int c = i % m;

            if (map[r][c] == 0) {
                map[r][c] = 1;
                dfs(i + 1, cnt+1);
                map[r][c] = 0;
            }
        }
    }

    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    visit[i][j] = true;
                    if (map[i][j] == 2) {
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            for (int[] d : dir) {

                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr > -1 && nr < n && nc > -1 && nc < m && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        ans = Math.max(ans, getSafeArea(visit));
    }

    private static int getSafeArea(boolean[][] visit) {

        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    num++;
                }
            }
        }

        return num;
    }
}
