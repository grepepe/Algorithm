package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon7576 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[][] board = new int[n][m];
        List<int[]> ripeTomato = new ArrayList<>();
        final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] == 1) {
                    ripeTomato.add(new int[]{i, j});
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int[] rt : ripeTomato) {
            q.offer(new int[]{rt[0], rt[1]});
        }

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            for (int[] ints : dir) {

                int r = tmp[0] + ints[0];
                int c = tmp[1] + ints[1];

                if (r > -1 && r < n && c > -1 && c < m && board[r][c] == 0) {
                    board[r][c] = board[tmp[0]][tmp[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }

        System.out.print(getAns(board) - 1);
    }

    private static int getAns(int[][] boards) {

        int ans = 0;

        for (int[] board : boards) {
            for (int b : board) {
                if (b == 0) {
                    return 0;
                }
                ans = Math.max(ans, b);
            }
        }
        return ans;
    }
}
