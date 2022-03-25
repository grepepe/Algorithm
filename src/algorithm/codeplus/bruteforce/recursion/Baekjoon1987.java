package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1987 {

    private static int r, c;
    private static char[][] map;
    private static final boolean[] visit = new boolean[26];
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {

            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        visit[map[0][0] - 'A'] = true;

        dfs(1, 0, 0);

        System.out.print(ans);
    }

    private static void dfs(int cnt, int cr, int cc) {

        boolean canGo = false;

        for (int[] d : dir) {

            int nr = cr + d[0];
            int nc = cc + d[1];

            if (nr > -1 && nc > -1 && nr < r && nc < c && !visit[map[nr][nc] - 'A']) {
                canGo = true;
                visit[map[nr][nc] - 'A'] = true;
                dfs(cnt + 1, nr, nc);
                visit[map[nr][nc] - 'A'] = false;
            }
        }

        if (!canGo) {
            ans = Math.max(ans, cnt);
        }
    }
}
