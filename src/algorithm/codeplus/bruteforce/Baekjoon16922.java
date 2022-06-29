package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon16922 {

    private static int n;
    private static final int[] roman = {1, 5, 10, 50};
    private static final boolean[] visit = new boolean[1001];
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();

        dfs(0, 0, 0);

        System.out.print(ans);
    }

    private static void dfs(int cnt, int sum, int idx) {
        if (cnt == n) {
            if (!visit[sum]) {
                visit[sum] = true;
                ans++;
            }
        } else {
            for (int i = idx; i < 4; i++) {
                dfs(cnt + 1, sum + roman[i], i);
            }
        }
    }
}
