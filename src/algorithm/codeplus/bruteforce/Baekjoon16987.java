package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16987 {

    private static int n;
    private static int[] durability;
    private static int[] weight;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        durability = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        dfs(0);

        System.out.print(ans);
    }

    private static void dfs(int idx) {
        if (idx == n) {
            ans = Math.max(ans, getBrokenEggNum());
            return;
        }

        if (durability[idx] > 0) {

            boolean breakable = false;

            for (int i = 0; i < n; i++) {
                if (i != idx && durability[i] > 0) {
                    durability[idx] -= weight[i];
                    durability[i] -= weight[idx];
                    dfs(idx + 1);
                    durability[idx] += weight[i];
                    durability[i] += weight[idx];
                    breakable = true;
                }
            }

            if (!breakable) {
                dfs(idx + 1);
            }
        } else {
            dfs(idx + 1);
        }
    }

    private static int getBrokenEggNum() {

        int num = 0;

        for (int i = 0; i < n; i++) {
            if (durability[i] <= 0) {
                num++;
            }
        }

        return num;
    }
}
