package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14501 {

    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        String[] input;

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        searchAnd(n, t, p, 1, 0);

        System.out.print(ans);
    }

    private static void searchAnd(int n, int[] t, int[] p, int cur, int total) {
        for (int i = cur; i <= n; i++) {
            if (i + t[i] <= n + 1) {
                searchAnd(n, t, p, i + t[i], total + p[i]);
            }
        }
        ans = Math.max(ans, total);
    }

}
