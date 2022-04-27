package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2875 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;

        while (true) {
            n -= 2;
            m -= 1;
            if (n < 0 || m < 0 || (n + m) < k) {
                break;
            }
            ans++;
        }

        System.out.print(ans);
    }
}
