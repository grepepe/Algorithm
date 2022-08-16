package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int ans = n + 1;
        int start = 0;
        int end = 0;
        int sum = arr[0];

        while (true) {
            if (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= arr[start++];
            } else {
                if (++end >= n) {
                    break;
                }
                sum += arr[end];
            }
        }

        System.out.print(ans > n ? 0 : ans);
    }
}
