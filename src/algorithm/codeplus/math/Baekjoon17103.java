package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17103 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[1000001];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j < isNotPrime.length; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 2; i + i <= n; i++) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
