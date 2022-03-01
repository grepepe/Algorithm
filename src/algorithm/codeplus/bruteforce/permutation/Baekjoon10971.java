package algorithm.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10971 {

    private static int[] perm;
    private static boolean[] visited;
    private static int ans = 10000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] city = new int[n][n];
        visited = new boolean[n];
        perm = new int[n];

        for (int i = 0; i < city.length; i++) {
            city[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        searchAns(n, city, 0, 0);

        System.out.print(ans);
    }

    private static void searchAns(int n, int[][] city, int cnt, int cost) {
        if (cnt == n) {
            if (city[perm[cnt - 1]][perm[0]] != 0) {
                ans = Math.min(ans, cost + city[perm[cnt - 1]][perm[0]]);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                perm[cnt] = i;
                visited[i] = true;
                if (cnt == 0) {
                    searchAns(n, city, cnt + 1, cost);
                } else if (city[perm[cnt - 1]][perm[cnt]] != 0) {
                    searchAns(n, city, cnt + 1, cost + city[perm[cnt - 1]][perm[cnt]]);
                }
                visited[i] = false;
            }
        }

    }
}
