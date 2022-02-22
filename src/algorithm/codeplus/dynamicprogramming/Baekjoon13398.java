package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13398 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][2];
        int ans = -1000;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = arr[1];
        dp[1][1] = arr[1];

        for (int i = 2; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], arr[i]);
        }
        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.print(ans);
    }
}
