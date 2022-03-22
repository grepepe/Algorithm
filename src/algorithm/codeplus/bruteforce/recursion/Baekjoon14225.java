package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14225 {

    private static int n;
    private static int[] s;
    private static final boolean[] possibleSum = new boolean[2000001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        for (int i = 1; i < possibleSum.length; i++) {
            if (!possibleSum[i]) {
                System.out.print(i);
                break;
            }
        }
    }

    private static void dfs(int idx, int sum) {
        if (idx == n) {
            possibleSum[sum] = true;
            return;
        }
        dfs(idx + 1,  sum);
        dfs(idx + 1, sum + s[idx]);
    }
}
