package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17088 {

    private static int n;
    private static int[] b;
    private static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        b = new int[n];
        ans = n + 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        dfs(0, 0, 0);

        if (ans == n + 1) {
            ans = -1;
        }

        System.out.print(ans);
    }

    private static void dfs(int idx, int cnt, int diff) {
        if (ans > cnt) {
            if (idx == n) {
                ans = cnt;
            } else {

                int tmpDiff;

                if (idx < 2) {
                    tmpDiff = idx == 0 ? diff : b[idx] - b[idx - 1];

                    dfs(idx + 1, cnt, tmpDiff);
                    b[idx]--;
                    dfs(idx + 1, cnt + 1, tmpDiff - 1);
                    b[idx] += 2;
                    dfs(idx + 1, cnt + 1, tmpDiff + 1);
                    b[idx]--;
                } else {
                    tmpDiff = b[idx] - b[idx - 1];

                    if (tmpDiff == diff) {
                        dfs(idx + 1, cnt, diff);
                    } else if (tmpDiff - 1 == diff) {
                        b[idx]--;
                        dfs(idx + 1, cnt + 1, diff);
                        b[idx]++;
                    } else if (tmpDiff + 1 == diff) {
                        b[idx]++;
                        dfs(idx + 1, cnt + 1, diff);
                        b[idx]--;
                    }
                }
            }
        }
    }
}
