package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1600 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        br.close();

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visit = new boolean[h][w][k+1];
        final int[][][] dir = {{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}, {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}}};

        q.offer(new int[]{0, 0, k, 0});
        visit[0][0][k] = true;

        int ans = -1;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == h - 1 && tmp[1] == w - 1) {
                ans = tmp[3];
                break;
            }

            for (int[] d : dir[0]) {

                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr > -1 && nc > -1 && nr < h && nc < w && !map[nr][nc] && !visit[nr][nc][tmp[2]]) {
                    visit[nr][nc][tmp[2]] = true;
                    q.offer(new int[]{nr, nc, tmp[2], tmp[3] + 1});
                }
            }

            if (tmp[2] > 0) {
                for (int[] d : dir[1]) {

                    int nr = tmp[0] + d[0];
                    int nc = tmp[1] + d[1];

                    if (nr > -1 && nc > -1 && nr < h && nc < w && !map[nr][nc] && !visit[nr][nc][tmp[2]-1]) {
                        visit[nr][nc][tmp[2]-1] = true;
                        q.offer(new int[]{nr, nc, tmp[2] - 1, tmp[3] + 1});
                    }
                }
            }
        }

        System.out.print(ans);

    }

}
