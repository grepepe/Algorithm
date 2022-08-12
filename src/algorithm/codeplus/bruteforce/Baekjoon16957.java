package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16957 {

    private static int r, c;
    private static int[][] board;
    private static int[][][] dp;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        dp = new int[r][c][2];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][0] = i;
                dp[i][j][1] = j;
            }
        }
        br.close();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dfs(i, j);
            }
        }

        int[][] ans = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[dp[i][j][0]][dp[i][j][1]]++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int[] dfs(int i, int j) {

        if (dp[i][j][0] != i || dp[i][j][1] != j) {
            return dp[i][j];
        }

        int tmp = board[i][j];
        int[] pos = new int[]{i, j};
        int nr = i;
        int nc = j;

        for (int[] d : dir) {

            int tmpR = i + d[0];
            int tmpC = j + d[1];

            if (tmpR > -1 && tmpC > -1 && tmpR < r && tmpC < c && tmp > board[tmpR][tmpC]) {
                tmp = board[tmpR][tmpC];
                nr = tmpR;
                nc = tmpC;
            }
        }

        if (tmp < board[i][j]) {
            pos = dfs(nr, nc);
            dp[i][j] = dp[pos[0]][pos[1]];
        }

        return pos;
    }
}
