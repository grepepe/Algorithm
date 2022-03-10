package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon2178 {

    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int n, m;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            String tmp = br.readLine();

            for (int j = 1; j <= m; j++) {
                if (tmp.charAt(j-1) == '0') {
                    map[i][j] = true;
                }
            }
        }

        dfs();
    }

    private static void dfs() {

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        q.offer(new int[]{1, 1, 1});

        while (!q.isEmpty()) {

            int r = q.peek()[0];
            int c = q.peek()[1];
            int cnt = q.poll()[2];

            if (r == n && c == m) {
                System.out.print(cnt);
                break;
            }

            for (int[] d : dir) {

                int tmpR = r + d[0];
                int tmpC = c + d[1];

                if (tmpR > 0 && tmpC > 0 && tmpR <= n && tmpC <= m && !map[tmpR][tmpC]) {
                    map[tmpR][tmpC] = true;
                    q.offer(new int[]{tmpR, tmpC, cnt + 1});
                }
            }
        }
    }
}
