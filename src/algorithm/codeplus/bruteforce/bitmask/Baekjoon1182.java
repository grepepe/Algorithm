package algorithm.codeplus.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1182 {

    private static int n;
    private static int s;
    private static int[] arr;
    private static int sum = 0;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        arr = new int[n];
        input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i <= n; i++) {
            dfs(0, i, 0);
        }

        System.out.print(ans);
    }

    private static void dfs(int cnt, int num, int cur) {
        if (cnt == num) {
            if (sum == s) {
                ans++;
            }
            return;
        }
        for (int i = cur; i < n; i++) {
            sum += arr[i];
            dfs(cnt + 1, num, i + 1);
            sum -= arr[i];
        }
    }
}
