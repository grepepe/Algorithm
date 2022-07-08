package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15683 {

    private static int n;
    private static int m;
    private static final List<int[]> cctv = new ArrayList<>();
    private static int size;
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int[][][] order = {{}, {{0}, {1}, {2}, {3}}, {{0, 2}, {1, 3}}, {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, {{0, 1, 2, 3}}};
    private static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        ans = n * m;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new int[]{i, j, map[i][j]});
                }
            }
        }

        size = cctv.size();

        br.close();

        dfs(0, map);

        System.out.print(ans);
    }

    private static void dfs(int cnt, int[][] map) {
        if (ans != 0) {
            if (cnt == size) {
                ans = Math.min(ans, getBlindSpotNum(map));
            } else {

                int[] tmp = cctv.get(cnt);

                for (int[] or : order[tmp[2]]) {

                    int[][] tmpMap = new int[n][m];

                    for (int i = 0; i < n; i++) {
                        System.arraycopy(map[i], 0, tmpMap[i], 0, m);
                    }

                    for (int o : or) {
                        checkMap(tmpMap,tmp[0] + dir[o][0], tmp[1] + dir[o][1], o);
                    }
                    dfs(cnt + 1, tmpMap);
                }
            }
        }
    }

    private static void checkMap(int[][] map, int r, int c, int d) {

        while (r > -1 && c > -1 && r < n && c < m && map[r][c] != 6) {
            if (map[r][c] == 0) {
                map[r][c] = 7;
            }
            r += dir[d][0];
            c += dir[d][1];
        }
    }

    private static int getBlindSpotNum(int[][] map) {

        int num = 0;

        for (int[] ma: map) {
            for (int m: ma) {
                if (m == 0) {
                    num++;
                }
            }
        }

        return num;
    }
}
