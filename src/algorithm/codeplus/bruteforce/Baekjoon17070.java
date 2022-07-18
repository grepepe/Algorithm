package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17070 {

    private static int n;
    private static boolean[][] map;
    private static final int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        br.close();

        dfs(1, 2, 0);

        System.out.print(ans);
    }

    private static void dfs(int r, int c, int d) {
        if (r == n && c == n) {
            ans++;
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            if ((i == 0 && d == 1) || (i == 1 && d == 0)) {
                continue;
            }

            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nc <= n && nr <= n && !map[nr][nc]) {
                if (i == 2 && (map[r + 1][c] || map[r][c + 1])) {
                    continue;
                }
                dfs(nr, nc, i);
            }
        }
    }
}
