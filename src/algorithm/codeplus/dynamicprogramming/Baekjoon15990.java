package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15990 {

    private static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[][] arr = new long[100001][4];

        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;

        for (int i = 4; i < arr.length; i++) {
            arr[i][1] = (arr[i - 1][2] + arr[i - 1][3]) % MOD;
            arr[i][2] = (arr[i - 2][1] + arr[i - 2][3]) % MOD;
            arr[i][3] = (arr[i - 3][1] + arr[i - 3][2]) % MOD;
        }

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            sb.append((arr[n][1] + arr[n][2] + arr[n][3]) % MOD).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
