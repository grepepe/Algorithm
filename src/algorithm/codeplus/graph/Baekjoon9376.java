package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon9376 {

    private static final int INF = 10001;
    private static final int[][] DIR = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static char[][] map;
    private static int[][][] dis;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()) + 2;
            int w = Integer.parseInt(st.nextToken()) + 2;
            List<int[]> start = new ArrayList<>();

            map = new char[h][w];
            start.add(new int[]{0, 0});

            for (int i = 1; i < h - 1; i++) {
                String str = br.readLine();
                for (int j = 1; j < w - 1; j++) {
                    map[i][j] = str.charAt(j - 1);
                    if (map[i][j] == '$') {
                        start.add(new int[]{i, j});
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                map[i][0] = '.';
                map[i][w - 1] = '.';
            }

            for (int i = 0; i < w; i++) {
                map[0][i] = '.';
                map[h - 1][i] = '.';
            }

            dis = new int[3][h][w];

            for (int d = 0; d < 3; d++) {
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        dis[d][i][j] = INF;
                    }
                }
            }

            for (int i = 0; i < start.size(); i++) {
                makeDisTable(start.get(i)[0], start.get(i)[1], i);
            }

            int[][] sumDis = new int[h][w];

            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    for (int d = 0; d < 3; d++) {
                        sumDis[r][c] += dis[d][r][c];
                    }
                    if (map[r][c] == '#') {
                        sumDis[r][c] -= 2;
                    }
                }
            }

            int ans = 30004;

            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    ans = Math.min(ans, sumDis[r][c]);
                }
            }

            sb.append(ans == 30004 ? 0 : ans).append('\n');
        }
        br.close();

        System.out.print(sb);
    }

    private static void makeDisTable(int sr, int sc, int d) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        dis[d][sr][sc] = 0;
        pq.offer(new int[]{sr, sc, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            for (int i = 0; i < 4; i++) {

                int nr = cur[0] + DIR[i][0];
                int nc = cur[1] + DIR[i][1];

                if (nr > -1 && nc > -1 && nr < map.length && nc < map[0].length && map[nr][nc] != '*') {

                    int cost = cur[2];

                    if (map[nr][nc] == '#') {
                        cost++;
                    }

                    if (dis[d][nr][nc] > cost) {
                        dis[d][nr][nc] = cost;
                        pq.offer(new int[]{nr, nc, cost});
                    }
                }
            }
        }
    }
}
