package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon6087 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[h][w];
        int[][] c = new int[2][2];
        int cIdx = 0;

        for (int i = 0; i < h; i++) {

            String input = br.readLine();

            for (int j = 0; j < w; j++) {

                char tmp = input.charAt(j);

                if (tmp == 'C') {
                    c[cIdx][0] = i;
                    c[cIdx++][1] = j;
                }
                map[i][j] = tmp == '*';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] mirror = new int[h][w];

        for (int[] m : mirror) {
            Arrays.fill(m, h * w);
        }

        mirror[c[0][0]][c[0][1]] = 0;
        for (int i = 0; i < dir.length; i++) {
            q.offer(new int[]{c[0][0], c[0][1], i});
        }

        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            int nr = tmp[0] + dir[tmp[2]][0];
            int nc = tmp[1] + dir[tmp[2]][1];

            if (nr > -1 && nr < h && nc > -1 && nc < w && !map[nr][nc] && mirror[nr][nc] >= mirror[tmp[0]][tmp[1]]) {
                mirror[nr][nc] = mirror[tmp[0]][tmp[1]];
                q.offer(new int[]{nr, nc, tmp[2]});
            }

            int[] rotate = new int[2];
            rotate[0] = tmp[2] < 1 ? 3 : tmp[2] - 1;
            rotate[1] = tmp[2] > 2 ? 0 : tmp[2] + 1;

            for (int r : rotate) {
                nr = tmp[0] + dir[r][0];
                nc = tmp[1] + dir[r][1];

                if (nr > -1 && nr < h && nc > -1 && nc < w && !map[nr][nc] && mirror[nr][nc] >= mirror[tmp[0]][tmp[1]] + 1) {
                    mirror[nr][nc] = mirror[tmp[0]][tmp[1]] + 1;
                    q.offer(new int[]{nr, nc, r});
                }
            }
        }

        System.out.print(mirror[c[1][0]][c[1][1]]);
    }
}
