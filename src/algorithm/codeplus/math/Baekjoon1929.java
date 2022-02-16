package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                sb.append(i).append("\n");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
