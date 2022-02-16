package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] isNotPrime = new boolean[1001];
        int ans = 0;

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < isNotPrime.length; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (n-- > 0) {
            if (!isNotPrime[Integer.parseInt(st.nextToken())]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
