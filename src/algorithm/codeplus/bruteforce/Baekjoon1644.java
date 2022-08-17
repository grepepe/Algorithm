package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1644 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if (n == 1) {
            System.out.print(0);
            return;
        }

        boolean[] isNotPrime = new boolean[n + 1];
        int size = 0;

        for (int i = 2; i <= n; i++) {
            if(!isNotPrime[i]) {
                size++;
                for (int j = 2 * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int[] prime = new int[size];
        int idx = 0;

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                prime[idx++] = i;
            }
        }

        int s = 0;
        int e = 0;
        int sum = prime[0];
        int ans = 0;

        while (e < size) {
            if (sum == n) {
                ans++;
                sum -= prime[s++];
            } else if (sum < n) {
                if (++e < size) {
                    sum += prime[e];
                }
            } else {
                sum -= prime[s++];
            }
        }

        System.out.print(ans);
    }
}
