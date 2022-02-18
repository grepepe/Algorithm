package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10844 {

    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[101][10];
        long ans = 0;

        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            arr[i][0] = arr[i - 1][1];
            arr[i][9] = arr[i - 1][8];
            for (int j = 1; j < 9; j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % MOD;
            }
        }

        for (int i = 0; i < 10; i++) {
            ans += arr[n][i];
        }

        System.out.print(ans % MOD);
    }
}
