package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1783 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans;

        if (n == 1) {
            ans = 1;
        } else if (n == 2) {
            ans = Math.min((m + 1) / 2, 4);
        } else {
            if (m < 7) {
                ans = Math.min(m, 4);
            } else {
                ans = m-2;
            }
        }

        System.out.print(ans);
    }
}
