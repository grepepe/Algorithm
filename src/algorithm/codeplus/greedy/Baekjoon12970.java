package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12970 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder ans = new StringBuilder();

        if (k > (n / 2) * (n - n / 2)) {
            ans.append(-1);
        } else {

            int a = 0;
            int b = n;

            while (a * b < k) {
                a++;
                b--;
            }

            ans.append("A".repeat(Math.max(0, a)));
            ans.append("B".repeat(Math.max(0, b)));

            int tmp = a * b;
            int idx = a - 1;

            while (tmp != k) {
                ans.replace(idx, idx + 1, "B");
                ans.replace(idx + 1, idx + 2, "A");
                idx++;
                tmp--;
            }
        }

        System.out.print(ans);
    }
}
