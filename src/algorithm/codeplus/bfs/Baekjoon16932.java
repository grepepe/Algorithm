package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16932 {

    private static int[][] map;
    private static int m;
    private static int n;
    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final List<Integer> sizeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for (int i = 0; i < 2; i++) {
            sizeList.add(0);
        }

        int sign = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {

                    Queue<int[]> q = new LinkedList<>();
                    int size = 1;

                    q.offer(new int[]{i, j});
                    map[i][j] = sign;

                    while (!q.isEmpty()) {

                        int[] pos = q.poll();

                        for (int[] d : DIR) {

                            int nr = pos[0] + d[0];
                            int nc = pos[1] + d[1];

                            if (nr > -1 && nc > -1 && nr < n && nc < m && map[nr][nc] == 1) {
                                map[nr][nc] = sign;
                                q.offer(new int[]{nr, nc});
                                size++;
                            }
                        }
                    }
                    sizeList.add(size);
                    sign++;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    ans = Math.max(ans, getSize(i, j));
                }
            }
        }

        System.out.print(ans);
    }

    private static int getSize(int r, int c) {

        Set<Integer> visit = new HashSet<>();
        int size = 1;

        for (int[] d : DIR) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr > -1 && nc > -1 && nr < n && nc < m && map[nr][nc] > 1 && !visit.contains(map[nr][nc])) {
                visit.add(map[nr][nc]);
                size += sizeList.get(map[nr][nc]);
            }
        }

        return size;
    }
}
