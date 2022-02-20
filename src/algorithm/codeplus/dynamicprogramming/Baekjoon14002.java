package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon14002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] previous = new int[n + 1];
        int ans = 0, lastIdx = 0;
        Stack<Integer> stk = new Stack<>();

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            previous[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    previous[i] = j;
                }
            }

            if (ans < dp[i]) {
                ans = dp[i];
                lastIdx = i;
            }
        }

        sb.append(ans).append("\n");
        for (int i = 0; i < ans; i++) {
            stk.push(arr[lastIdx]);
            lastIdx = previous[lastIdx];
        }

        while (!stk.empty()) {
            sb.append(stk.pop()).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
