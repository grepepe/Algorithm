package algorithm.codeplus.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1062 {

    private static int k;
    private static int[] inputs;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        inputs = new int[n];

        for (int i = 0; i < n; i++) {
            for (char c : br.readLine().toCharArray()) {
                inputs[i] |= 1 << (c - 'a' + 1);
            }
        }

        if (k > 4) {

            int bitmask = 0;

            bitmask |= 1 << 1;
            bitmask |= 1 << ('n' - 'a' + 1);
            bitmask |= 1 << ('t' - 'a' + 1);
            bitmask |= 1 << ('i' - 'a' + 1);
            bitmask |= 1 << ('c' - 'a' + 1);

            dfs(0, 5, bitmask);
        }

        System.out.print(ans);
    }

    private static void dfs(int cur, int cnt, int bitmask) {
        if (cnt == k) {

            int tmp = 0;

            for (int input : inputs) {
                if ((input & bitmask) == input) {
                    tmp++;
                }
            }

            ans = Math.max(ans, tmp);
            return;
        }

        for (int i = cur; i < 27; i++) {
            if ((bitmask & (1 << i)) == 0) {
                dfs(i + 1, cnt + 1, bitmask | (1 << i));
            }
        }
    }
}
