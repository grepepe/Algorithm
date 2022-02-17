package algorithm.codeplus.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16194 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] p = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i < p.length; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            arr[i] = 100000000;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] = Math.min(arr[i], arr[i-j] + p[j]);
            }
        }

        System.out.print(arr[n]);
    }
}
