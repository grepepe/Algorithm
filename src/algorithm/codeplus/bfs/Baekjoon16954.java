package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon16954 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[8][8];
        final int[][] dir = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int ans = 0;

        for (int i = 0; i < 8; i++) {

            String input = br.readLine();

            for (int j = 0; j < 8; j++) {
                map[i][j] = input.charAt(j) == '#';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[8][8];

        visit[7][0] = true;
        q.offer(new int[]{7, 0});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == 0) {
                ans = 1;
                break;
            }

            for (int[] d : dir) {

                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr > 0 && nr < 8 && nc > -1 && nc < 8 && !map[nr][nc] && !visit[nr-1][nc]  && !map[nr-1][nc]) {
                    visit[nr-1][nc] = true;
                    q.offer(new int[]{nr - 1, nc});
                }
            }
        }

        System.out.print(ans);
    }
}
