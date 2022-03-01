package algorithm.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10974 {

    private static final StringBuilder sb = new StringBuilder();
    private static int bitmask = 0;
    private static int[] tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tmp = new int[n];

        permutation(n, 0);

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void permutation(int n, int cnt) {
        if (cnt == n) {
            for (int t : tmp) {
                sb.append(t).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if ((bitmask & (1 << i)) == 0) {
                bitmask |= 1 << i;
                tmp[cnt] = i;
                permutation(n, cnt + 1);
                bitmask &= ~(1 << i);
            }
        }
    }
}
