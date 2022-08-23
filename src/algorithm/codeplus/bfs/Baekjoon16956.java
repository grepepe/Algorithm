package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon16956 {

    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int r;
    private static int c;
    private static char[][] map;
    private static final List<int[]> wolf = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'W') {
                    wolf.add(new int[]{i, j});
                }
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        boolean canDefend = defendWolf();

        if (canDefend) {
            sb.append(1).append("\n");
            for (char[] ma : map) {
                for (char m : ma) {
                    sb.append(m);
                }
                sb.append("\n");
            }
        } else{
            sb.append(0).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean defendWolf() {

        for (int[] w : wolf) {
            for (int[] d : dir) {

                int nr = w[0] + d[0];
                int nc = w[1] + d[1];

                if (nr > -1 && nc > -1 && nr < r && nc < c) {
                    if (map[nr][nc] == 'S') {
                        return false;
                    } else if (map[nr][nc] == '.') {
                        map[nr][nc] = 'D';
                    }
                }
            }
        }

        return true;
    }
}
