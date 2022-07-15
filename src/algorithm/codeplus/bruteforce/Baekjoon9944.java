package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9944 {

    private static int n, m, size, checkNum;
    private static int[][] map;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            StringTokenizer st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            size = n * m;
            checkNum = 0;
            ans = 1000000;
            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (str.charAt(j) == '*') {
                        map[i][j] = 1;
                        checkNum++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 2;
                        checkNum++;
                        dfs(0, i, j);
                        map[i][j] = 0;
                        checkNum--;
                    }
                }
            }

            sb.append("Case ").append(caseNum++).append(": ").append(ans == 1000000 ? -1 : ans).append("\n");
        }

        br.close();

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(sb);
    }

    private static void dfs(int cnt, int r, int c) {
        if (ans <= cnt) {
            return;
        } else if (checkNum == size) {
            ans = cnt;
            return;
        }

        for (int d = 0; d < dir.length; d++) {

            int[] pos = check(r, c, d);

            if (pos[0] == r && pos[1] == c) {
                continue;
            }
            dfs(cnt + 1, pos[0], pos[1]);

            uncheck(pos[0], pos[1], r, c, d);
        }
    }

    private static void uncheck(int r, int c, int destR, int destC, int d) {

        int nr = r;
        int nc = c;

        while (nr != destR || nc != destC) {
            map[nr][nc] = 0;
            checkNum--;
            nr -= dir[d][0];
            nc -= dir[d][1];
        }
    }

    private static int[] check(int r, int c, int d) {

        int nr = r + dir[d][0];
        int nc = c + dir[d][1];

        while (canMove(nr, nc)) {
            map[nr][nc] = 2;
            checkNum++;
            nr += dir[d][0];
            nc += dir[d][1];
        }

        return new int[]{nr - dir[d][0], nc - dir[d][1]};
    }

    private static boolean canMove(int nr, int nc) {
        return nr > -1 && nc > -1 && nr < n && nc < m && map[nr][nc] == 0;
    }
}
