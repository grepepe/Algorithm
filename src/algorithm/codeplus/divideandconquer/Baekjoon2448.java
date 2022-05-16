package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2448 {

    private static char[][] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        ans = new char[n][2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], ' ');
        }

        getStars(n / 3, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (char[] a: ans) {
            for (char c : a) {
                sb.append(c);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void getStars(int phase, int startR, int startC) {
        if (phase == 1) {
            ans[startR][startC + 2] = '*';
            for (int i = 0; i < 2; i++) {
                ans[startR + 1][startC + (2 * i) + 1] = '*';
            }
            for (int i = 0; i < 5; i++) {
                ans[startR + 2][startC + i] = '*';
            }
        } else {
            getStars(phase / 2, startR, startC + (3 * (phase / 2)));
            getStars(phase / 2, startR + (3 * phase / 2), startC);
            getStars(phase / 2, startR + (3 * phase / 2), startC + (3 * phase));
        }
    }
}
