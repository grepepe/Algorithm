package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon16924 {

    private static int n, m;
    private static boolean[][] goal;
    private static boolean[][] check;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        goal = new boolean[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {

            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                goal[i][j] = tmp[j] == '*';
                check[i][j] = tmp[j] == '.';
            }
        }
        br.close();

        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (goal[i][j]) {

                    int s = getS(i, j);

                    if (s > 0) {
                        checkBoard(i, j, s);
                        ans.add(new int[]{i + 1, j + 1, s});
                    }
                }
            }
        }

        if (canMake()) {

            StringBuilder sb = new StringBuilder();

            sb.append(ans.size()).append("\n");
            for (int[] an : ans) {
                for (int a : an) {
                    sb.append(a).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        } else {
            System.out.print(-1);
        }
    }

    private static boolean canMake() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void checkBoard(int r, int c, int s) {
        check[r][c] = true;
        for (int i = 1; i <= s; i++) {
            check[r + i][c] = true;
            check[r - i][c] = true;
            check[r][c + i] = true;
            check[r][c - i] = true;
        }
    }

    private static int getS(int r, int c) {

        int s = Math.min(n, m);

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];
            int tmpS = 0;

            while (nr > -1 && nc > -1 && nr < n && nc < m && goal[nr][nc]) {
                tmpS++;
                nr += d[0];
                nc += d[1];
            }

            s = Math.min(s, tmpS);
        }

        return s;
    }
}
