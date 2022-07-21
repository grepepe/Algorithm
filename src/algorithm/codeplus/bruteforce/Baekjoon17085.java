package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17085 {

    private static int n, m, size;
    private static char[][] map;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        size = n * m;
        map = new char[n][m];
        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        br.close();

        dfs(0, 0, 1);

        System.out.print(ans);
    }

    private static void dfs(int idx, int cnt, int mul) {
        if (cnt == 2) {
            ans = Math.max(ans, mul);
            return;
        }

        for (int i = idx; i < size; i++) {

            int r = i / m;
            int c = i % m;

            if (map[r][c] == '#') {

                int size = 0;
                boolean possible = true;

                while (true) {
                    for (int[] d : dir) {

                        int nr = r + d[0] * size;
                        int nc = c + d[1] * size;

                        if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] != '#') {
                            possible = false;
                            break;
                        }
                    }

                    if (!possible) {
                        break;
                    }

                    for (int[] d : dir) {

                        int nr = r + d[0] * size;
                        int nc = c + d[1] * size;

                        map[nr][nc] = '*';
                    }

                    dfs(i + 1, cnt + 1, mul * (size * 4 + 1));

                    size++;
                }

                uncheck(r, c, size-1);
            }
        }

    }

    private static void uncheck(int r, int c, int size) {

        map[r][c] = '#';

        for (int[] d : dir) {

            int nr = r;
            int nc = c;

            for (int i = 0; i < size; i++) {
                nr += d[0];
                nc += d[1];
                map[nr][nc] = '#';
            }
        }
    }
}
