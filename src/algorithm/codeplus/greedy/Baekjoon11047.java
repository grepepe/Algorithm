package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int ans = 0;

        for (int i = n - 1; i > -1; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int a : arr) {
            if (k == 0) {
                break;
            }
            if (k >= a) {
                ans += k / a;
                k %= a;
            }
        }
        System.out.print(ans);
    }
}
