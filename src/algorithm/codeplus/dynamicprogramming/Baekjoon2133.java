package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2133 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if (n > 1) {
            dp[2] = 3;
        }
        for (int i = 4; i < dp.length; i++) {
            dp[i] = 3 * dp[i - 2];
            for (int j = 4; j <= i; j += 2) {
                dp[i] += 2 * dp[i - j];
            }
        }

        System.out.print(dp[n]);
    }
}
