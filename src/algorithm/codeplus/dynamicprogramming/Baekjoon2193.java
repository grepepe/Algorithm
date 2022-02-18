package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[91][2];

        arr[1][1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-1][1];
            arr[i][1] = arr[i-1][0];
        }

        System.out.print(arr[n][0] + arr[n][1]);
    }
}
