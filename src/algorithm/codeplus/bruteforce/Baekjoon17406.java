package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17406 {

    private static int n, m, k;
    private static int[][] a;
    private static int[][] rotateOp;
    private static int bitmask = 0;
    private static int ans = 5000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n + 1][m + 1];
        rotateOp = new int[k][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotateOp[i][0] = Integer.parseInt(st.nextToken());
            rotateOp[i][1] = Integer.parseInt(st.nextToken());
            rotateOp[i][2] = Integer.parseInt(st.nextToken());
        }

        br.close();

        dfs(0);

        System.out.print(ans);
    }

    private static void dfs(int cnt) {
        if (cnt == k) {
            ans = Math.min(ans, getMin());
            return;
        }

        for (int i = 0; i < k; i++) {
            if ((bitmask & (1 << i)) == 0) {
                bitmask |= 1 << i;
                rotate(i, false);
                dfs(cnt + 1);
                rotate(i, true);
                bitmask &= ~(1 << i);
            }
        }
    }

    private static int getMin() {

        int min = 5000;

        for (int i = 1; i <= n; i++) {

            int tmp = 0;

            for (int j = 1; j <= m; j++) {
                tmp += a[i][j];
            }

            min = Math.min(min, tmp);
        }

        return min;
    }

    private static void rotate(int idx, boolean dir) {

        int r = rotateOp[idx][0];
        int c = rotateOp[idx][1];
        int s = rotateOp[idx][2];
        int[][] tmp = new int[n+1][m+1];

        if (dir) {
            for (int i = 1; i <= s; i++) {
                for (int j = r + i; j > r - i; j--) {
                    tmp[j][c - i] = a[j - 1][c - i];
                }
                for (int j = c + i; j > c - i; j--) {
                    tmp[r + i][j] = a[r + i][j - 1];
                }
                for (int j = r - i; j < r + i; j++) {
                    tmp[j][c + i] = a[j + 1][c + i];
                }
                for (int j = c - i; j < c + i; j++) {
                    tmp[r - i][j] = a[r - i][j + 1];
                }
            }
        } else {
            for (int i = 1; i <= s; i++) {
                for (int j = r - i; j < r + i; j++) {
                    tmp[j][c - i] = a[j + 1][c - i];
                }
                for (int j = c - i; j < c + i; j++) {
                    tmp[r + i][j] = a[r + i][j + 1];
                }
                for (int j = r + i; j > r - i; j--) {
                    tmp[j][c + i] = a[j - 1][c + i];
                }
                for (int j = c + i; j > c - i; j--) {
                    tmp[r - i][j] = a[r - i][j - 1];
                }
            }
        }

        for (int i = 1; i <= s; i++) {
            for (int j = r - i; j < r + i; j++) {
                a[j][c - i] = tmp[j][c - i];
            }
            for (int j = c - i; j < c + i; j++) {
                a[r + i][j] = tmp[r + i][j];
            }
            for (int j = r + i; j > r - i; j--) {
                a[j][c + i] = tmp[j][c + i];
            }
            for (int j = c + i; j > c - i; j--) {
                a[r - i][j] = tmp[r - i][j];
            }
        }
    }
}
