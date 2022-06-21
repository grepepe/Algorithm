package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1300 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        br.close();

        long left = 1;
        long right = (long) n * n;
        long ans = 0;

        while (left <= right) {

            long mid = (left + right) / 2;
            long sum = 0;


            for (int i = 1; i <= n; i++) {
                sum += Math.min(n, mid / i);
            }

            if (sum < k) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
