package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16198 {

    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        findAns(w, n, 0);

        System.out.print(ans);
    }

    private static void findAns(int[] w, int n, int result) {

        if (n == 2) {
            ans = Math.max(ans, result);
            return;
        }

        for (int i = 1; i < n - 1; i++) {

            int[] next = new int[n - 1];

            System.arraycopy(w, 0, next, 0, i);
            System.arraycopy(w, i + 1, next, i, n - 1 - i);

            findAns(next, n - 1, w[i - 1] * w[i + 1] + result);
        }
    }
}
