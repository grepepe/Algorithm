package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon3055 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[r][c];
        int[] start = new int[2];
        int[] dest = new int[2];
        List<int[]> water = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < r; i++) {

            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                switch (input.charAt(j)) {
                    case 'D':
                        dest[0] = i;
                        dest[1] = j;
                        break;
                    case 'S':
                        start[0] = i;
                        start[1] = j;
                        break;
                    case 'X':
                        map[i][j] = true;
                        break;
                    case '*':
                        map[i][j] = true;
                        water.add(new int[]{i, j});
                        break;
                }
            }
        }

        final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> sq = new LinkedList<>();
        Queue<int[]> wq = new LinkedList<>(water);
        boolean[][] visit = new boolean[r][c];
        int wqSize = wq.size();
        int sqSize = 1;
        int phase = 0;

        visit[start[0]][start[1]] = true;
        sq.offer(new int[]{start[0], start[1]});

        while (!wq.isEmpty() || !sq.isEmpty()) {
            while (!wq.isEmpty() && wqSize-- != 0) {

                int[] tmp = wq.poll();

                for (int[] d : dir) {

                    int nr = tmp[0] + d[0];
                    int nc = tmp[1] + d[1];

                    if (nr > -1 && nr < r && nc > -1 && nc < c && !map[nr][nc]) {
                        if (nr != dest[0] || nc != dest[1]) {
                            map[nr][nc] = true;
                            wq.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            wqSize = wq.size();

            while (!sq.isEmpty() && sqSize-- != 0) {

                int[] tmp = sq.poll();

                if (tmp[0] == dest[0] && tmp[1] == dest[1]) {
                    ans = phase;
                    break;
                }

                for (int[] d : dir) {

                    int nr = tmp[0] + d[0];
                    int nc = tmp[1] + d[1];

                    if (nr > -1 && nr < r && nc > -1 && nc < c && !map[nr][nc] && !visit[nr][nc]) {
                        visit[nr][nc] = true;
                        sq.offer(new int[]{nr, nc});
                    }
                }
            }
            sqSize = sq.size();

            if (ans != 0) {
                break;
            }

            phase++;
        }

        System.out.print(ans == 0 ? "KAKTUS" : ans);
    }
}
