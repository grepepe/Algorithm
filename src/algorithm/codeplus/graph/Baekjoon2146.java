package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2146 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int cnt = 2;
        final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {

                    map[i][j] = cnt;

                    Queue<int[]> q = new LinkedList<>();

                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {

                        int[] tmp = q.poll();
                        boolean isEdge = false;

                        for (int[] d : dir) {

                            int r = tmp[0] + d[0];
                            int c = tmp[1] + d[1];

                            if (r > -1 && r < n && c > -1 && c < n) {
                                if (map[r][c] == 1) {
                                    map[r][c] = cnt;
                                    q.offer(new int[]{r, c});
                                } else if (!isEdge && map[r][c] == 0) {
                                    isEdge = true;
                                }
                            }
                        }

                        if (isEdge) {
                            edges.add(tmp);
                        }
                    }

                    cnt++;
                }
            }
        }

        int ans = 100 * 100;

        for (int[] e : edges) {

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visit = new boolean[n][n];
            int land = map[e[0]][e[1]];

            q.offer(new int[]{e[0], e[1], 0});
            visit[e[0]][e[1]] = true;

            while (!q.isEmpty()) {

                int[] tmp = q.poll();

                if (tmp[2] > ans) {
                    break;
                }

                if (map[tmp[0]][tmp[1]] != land && map[tmp[0]][tmp[1]] != 0) {
                    ans = Math.min(ans, tmp[2]-1);
                    break;
                }

                for (int[] d : dir) {

                    int r = tmp[0] + d[0];
                    int c = tmp[1] + d[1];

                    if (r > -1 && r < n && c > -1 && c < n && map[r][c] != land && !visit[r][c]) {
                        q.offer(new int[]{r, c, tmp[2] + 1});
                        visit[r][c] = true;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}
