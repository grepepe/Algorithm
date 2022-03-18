package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1261 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n+1][m+1];
        final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 1; i <= n; i++) {

            String input = br.readLine();

            for (int j = 1; j <= m; j++) {
                maze[i][j] = input.charAt(j-1) - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        pq.offer(new int[]{1, 1, 0});
        maze[1][1] = 2;

        while (!pq.isEmpty()) {

            int[] tmp = pq.poll();

            if (tmp[0] == n && tmp[1] == m) {
                System.out.print(tmp[2]);
                break;
            }

            for (int[] d : dir) {

                int r = tmp[0] + d[0];
                int c = tmp[1] + d[1];

                if (r > 0 && r <= n && c > 0 && c <= m && maze[r][c] != 2) {
                    if (maze[r][c] == 1) {
                        pq.offer(new int[]{r, c, tmp[2] + 1});
                    } else {
                        pq.offer(new int[]{r, c, tmp[2]});
                    }
                    maze[r][c] = 2;
                }
            }
        }
    }
}
