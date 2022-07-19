package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17069 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n + 1][n + 1];
        long[][][] dp = new long[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        br.close();

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (i == 1 && j == 2) {
                    dp[1][2][0] = 1;
                    continue;
                }
                if (!map[i][j]) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                    if (!map[i - 1][j] && !map[i][j - 1]) {
                        dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    }
                }
            }
        }

        System.out.print(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}
