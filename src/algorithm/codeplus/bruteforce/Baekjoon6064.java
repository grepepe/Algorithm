package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon6064 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] tmp;
        int m, n, x, y;
        int lcm, ans;

        while (t-- != 0) {
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (tmp[0] < tmp[1]) {
                m = tmp[1];
                n = tmp[0];
                x = tmp[3];
                y = tmp[2];
            } else {
                m = tmp[0];
                n = tmp[1];
                x = tmp[2];
                y = tmp[3];
            }

            lcm = m * n / gcd(m, n);
            ans = x;

            while (0 != (ans - y) % n) {
                ans += m;
                if (ans > lcm) {
                    ans = -1;
                    break;
                }
            }

            sb.append(ans).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


}
