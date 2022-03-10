package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2667 {

    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        int ansNum = 0;
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                board[i][j] = input[j] - '0';
                if (board[i][j] == 0) {
                    visit[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    ansList.add(bfs(board, visit, i, j));
                    ansNum++;
                }
            }
        }

        Collections.sort(ansList);

        System.out.println(ansNum);

        for (int a : ansList) {
            System.out.println(a);
        }

    }

    private static int bfs(int[][] board, boolean[][] visit, int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        int ans = 1;

        q.offer(new int[]{r, c});
        visit[r][c] = true;

        while (!q.isEmpty()) {

            int tmpR = q.peek()[0];
            int tmpC = q.poll()[1];

            for (int d = 0; d < 4; d++) {

                int newR = tmpR + dir[d][0];
                int newC = tmpC + dir[d][1];

                if (newR > -1 && newR < board.length && newC > -1 && newC < board.length && !visit[newR][newC]) {
                    visit[newR][newC] = true;
                    ans++;
                    q.offer(new int[]{newR, newC});
                }
            }

        }

        return ans;
    }
}
