package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15684 {

    private static int n;
    private static int h;
    private static int size;
    private static boolean[][] ladder;
    private static int ans = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new boolean[h + 1][n + 1];
        size = n * h;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        br.close();

        for (int i = 0; i <= 3; i++) {
            dfs(i, 0, 0);
            if (ans != -1) {
                break;
            }
        }

        System.out.print(ans);
    }

    private static void dfs(int num, int cnt, int idx) {
        if (ans != -1) {
            return;
        } else if (cnt == num) {
            if (isSatisfied()) {
                ans = cnt;
            }
            return;
        }

        for (int i = idx; i < size; i++) {

            int r = i / n + 1;
            int c = i % n + 1;

            if (!ladder[r][c]) {
                if ((c == 1 && !ladder[r][2]) || (c == n - 1 && !ladder[r][n - 2]) || (c > 1 && c < n - 1 && !ladder[r][c - 1] && !ladder[r][c + 1])) {
                    ladder[r][c] = true;
                    dfs(num, cnt + 1, i + 1);
                    ladder[r][c] = false;
                }
            }
        }
    }

    private static boolean isSatisfied() {

        for (int i = 1; i <= n; i++) {

            int row = 1;
            int col = i;

            while (row <= h) {
                if (col < n && ladder[row][col]) {
                    col++;
                } else if (col > 1 && ladder[row][col - 1]) {
                    col--;
                }
                row++;
            }

            if (col != i) {
                return false;
            }
        }

        return true;
    }
}
