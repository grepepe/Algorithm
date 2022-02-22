package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11054 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp1[i] = 1;
            dp2[i] = 1;
        }


        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                }
                if (arr[arr.length - i] > arr[arr.length - j] && dp2[arr.length - i] < dp2[arr.length - j] + 1) {
                    dp2[arr.length - i] = dp2[arr.length - j] + 1;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i] - 1);
        }

        System.out.print(ans);
    }
}
