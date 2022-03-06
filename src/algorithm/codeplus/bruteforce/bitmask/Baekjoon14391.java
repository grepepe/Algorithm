package algorithm.codeplus.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14391 {

    private static int n;
    private static int m;
    private static int ans = 0;
    private static int[][] arr;
    private static int bitmask = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String tmp;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }

        dfs(0, 0, 0);

        System.out.print(ans);
    }

    private static void dfs(int cnt, int cur, int sum) {
        if (cnt == n * m) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = cur; i < n * m; i++) {
            if ((bitmask & (1 << (i + 1))) == 0) {

                int tmp, part;

                tmp = 1;
                part = arr[i / m][i % m];
                bitmask |= (1 << (i + 1));
                dfs(cnt + tmp, i + 1, sum + part);

                for (int j = i + 1; j % m != 0; j++) {
                    if ((bitmask & (1 << (j + 1))) != 0) {
                        break;
                    }
                    tmp++;
                    bitmask |= (1 << (j + 1));
                    part *= 10;
                    part += arr[j / m][j % m];
                    dfs(cnt + tmp, j + 1, sum + part);
                }

                for (int j = i + 1; j < i + tmp; j++) {
                    bitmask &= ~(1 << (j + 1));
                }

                tmp = 1;
                part = arr[i / m][i % m];

                for (int j = i + m; j < n * m; j += m) {
                    if ((bitmask & (1 << (j + 1))) != 0) {
                        break;
                    }
                    tmp++;
                    bitmask |= (1 << (j + 1));
                    part *= 10;
                    part += arr[j / m][j % m];
                    dfs(cnt + tmp, i + 1, sum + part);
                }

                for (int j = i + m; j < i + m * tmp; j += m) {
                    bitmask &= ~(1 << (j + 1));
                }

                bitmask &= ~(1 << (i + 1));
            }
        }
    }
}
