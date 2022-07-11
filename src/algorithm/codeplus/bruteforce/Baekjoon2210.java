package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon2210 {

    private static final int[][] map = new int[5][5];
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final Set<Integer> num = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, 0);
            }
        }

        System.out.print(num.size());
    }

    private static void dfs(int r, int c, int cnt, int tmp) {
        tmp *= 10;
        tmp += map[r][c];

        if (cnt == 5) {
            num.add(tmp);
        } else {
            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr > -1 && nc > -1 && nr < 5 & nc < 5) {
                    dfs(nr, nc, cnt + 1, tmp);
                }
            }
        }
    }
}
