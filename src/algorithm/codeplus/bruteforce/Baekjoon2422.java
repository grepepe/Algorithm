package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2422 {

    private static int n;
    private static boolean[][] bad;
    private static boolean[] select;
    private static int ans = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bad = new boolean[n + 1][n + 1];
        select = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int ice1 = Integer.parseInt(st.nextToken());
            int ice2 = Integer.parseInt(st.nextToken());

            bad[ice1][ice2] = true;
            bad[ice2][ice1] = true;
        }
        br.close();

        dfs(0, 1);

        System.out.print(ans);
    }

    private static void dfs(int cnt, int idx) {
        if (cnt == 3) {
            ans++;
        } else {
            for (int i = idx; i <= n; i++) {
                if(isOk(i)){
                    select[i] = true;
                    dfs(cnt + 1, i + 1);
                    select[i] = false;
                }
            }
        }
    }

    private static boolean isOk(int idx) {
        for (int i = 1; i <= n; i++) {
            if (select[i] && bad[idx][i]) {
                return false;
            }
        }
        return true;
    }
}
