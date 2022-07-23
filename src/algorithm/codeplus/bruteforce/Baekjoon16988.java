package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16988 {

    private static int n, m;
    private static int size;
    private static int[][] map;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        size = n * m;
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        dfs(0, 0);

        System.out.print(ans);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == 2) {
            ans = Math.max(ans, getCaughtEnemyNum());
            return;
        }

        for (int i = idx; i < size; i++) {

            int r = i / m;
            int c = i % m;

            if (map[r][c] == 0) {
                map[r][c] = 1;
                dfs(i + 1, cnt + 1);
                map[r][c] = 0;
            }
        }
    }

    private static int getCaughtEnemyNum() {

        boolean[][] visit = new boolean[n][m];
        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2 && !visit[i][j]) {

                    Queue<int[]> q = new LinkedList<>();
                    int enemyNum = 0;
                    boolean canCaught = true;

                    q.offer(new int[]{i, j});
                    visit[i][j] = true;

                    while (!q.isEmpty()) {

                        int[] tmp = q.poll();

                        enemyNum++;

                        for (int[] d : dir) {

                            int nr = tmp[0] + d[0];
                            int nc = tmp[1] + d[1];

                            if (nr > -1 && nc > -1 && nr < n && nc < m && !visit[nr][nc]) {
                                if (map[nr][nc] == 0) {
                                    canCaught = false;
                                } else if (map[nr][nc] == 2) {
                                    q.offer(new int[]{nr, nc});
                                    visit[nr][nc] = true;
                                }
                            }
                        }
                    }

                    if (canCaught) {
                        num += enemyNum;
                    }
                }
            }
        }

        return num;
    }
}
