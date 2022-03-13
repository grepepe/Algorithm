package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16929 {

    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int n, m;
    private static char[][] map;
    private static boolean[][] visit;
    private static final int[] start = new int[2];
    private static boolean isFound = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];


        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit = new boolean[n][m];
                start[0] = i;
                start[1] = j;
                dfs(i, j, map[i][j], 1);
                if (isFound) {
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }

        System.out.print(isFound ? "Yes" : "No");
    }

    private static void dfs(int r, int c, char color, int cnt) {

        int tmpR, tmpC;

        for (int[] ints : dir) {

            tmpR = r + ints[0];
            tmpC = c + ints[1];

            if (tmpR > -1 && tmpR < n && tmpC > -1 && tmpC < m && map[tmpR][tmpC] == color && !visit[tmpR][tmpC]) {
                if (tmpR == start[0] && tmpC == start[1] && cnt > 3) {
                    isFound = true;
                    return;
                }
                visit[tmpR][tmpC] = true;
                dfs(tmpR, tmpC, color, cnt+1);
                visit[tmpR][tmpC] = false;
            }

            if (isFound) {
                return;
            }
        }
    }
}
