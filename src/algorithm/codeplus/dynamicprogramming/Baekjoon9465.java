package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[n+1][3];
            StringTokenizer st;

            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j < arr[0].length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[0][1];
            dp[1][2] = arr[1][1];

            for (int i = 2; i < dp.length; i++) {
                dp[i][0] += Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
                dp[i][1] += Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[0][i];
                dp[i][2] += Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[1][i];
            }

            sb.append(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2])).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
