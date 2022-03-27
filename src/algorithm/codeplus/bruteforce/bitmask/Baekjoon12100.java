package algorithm.codeplus.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12100 {

    private static int n;
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, map);

        System.out.print(ans);
    }

    private static void dfs(int cnt, int[][] map) {
        if (cnt < 5) {
            for (int[] d : dir) {
                dfs(cnt + 1, move(d, map));
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans < map[i][j]) {
                        ans = map[i][j];
                    }
                }
            }
        }
    }

    private static int[][] move(int[] d, int[][] map) {

        int[][] tmp = new int[n][n];
        int start, end;

        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, tmp[i], 0, n);
        }

        if (d[0] == 0) {
            if (d[1] > 0) {
                start = 0;
                end = n;
            } else {
                start = n - 1;
                end = -1;
            }

            for (int i = 0; i < n; i++) {
                add(tmp[i], start, end, d[1]);
                toSide(tmp[i], start, end, d[1]);
            }
        } else {
            if (d[0] > 0) {
                start = 0;
                end = n;
            } else {
                start = n - 1;
                end = -1;
            }
            for (int i = 0; i < n; i++) {

                int[][] diagonalTmp = new int[n][n];

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        diagonalTmp[k][j] = map[j][k];
                    }
                }

                add(diagonalTmp[i], start, end, d[0]);
                toSide(diagonalTmp[i], start, end, d[0]);

                for (int j = 0; j < n; j++) {
                    tmp[j][i] = diagonalTmp[i][j];
                }
            }
        }

        return tmp;
    }

    private static void toSide(int[] tmp, int start, int end, int d) {

        int idx = end;

        for (int j = start; j != end; j += d) {
            if (tmp[j] == 0) {
                idx = j;
                break;
            }
        }

        for (int j = idx; j != end; j += d) {
            if (tmp[j] != 0) {
                tmp[idx] = tmp[j];
                tmp[j] = 0;
                idx += d;
            }
        }
    }

    private static void add(int[] tmp, int start, int end, int d) {

        int idx = -1;

        for (int j = start; j != end; j += d) {
            if (tmp[j] != 0) {
                if (idx == -1 || tmp[j] != tmp[idx]) {
                    idx = j;
                } else {
                    tmp[idx] += tmp[j];
                    tmp[j] = 0;
                    idx = -1;
                }
            }
        }
    }
}
