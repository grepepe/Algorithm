package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11722 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }


        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] < arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);

    }
}
