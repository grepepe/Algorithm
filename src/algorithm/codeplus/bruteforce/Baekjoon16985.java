package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16985 {

    private static final boolean[][][] input = new boolean[5][5][5];
    private static final boolean[][][] maze = new boolean[5][5][5];
    private static int bitmask = 0;
    private static final int[] order = new int[5];
    private static final int[][] dir = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
    private static int ans = 125;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    input[i][j][k] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
        }
        br.close();

        orderBoard(0);

        System.out.print(ans == 125 ? -1 : ans);
    }

    private static void rotateBoard(int cnt) {
        if (cnt == 5) {
            if (maze[0][0][0]) {
                getMinDis();
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            rotate(maze[cnt]);
            rotateBoard(cnt + 1);
        }
    }

    private static void getMinDis() {

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visit = new boolean[5][5][5];

        q.offer(new int[]{0, 0, 0, 0});
        visit[0][0][0] = true;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (ans <= tmp[3]) {
                continue;
            } else if (tmp[0] == 4 && tmp[1] == 4 && tmp[2] == 4) {
                ans = tmp[3];
                break;
            }

            for (int[] d : dir) {

                int nh = tmp[0] + d[0];
                int nr = tmp[1] + d[1];
                int nc = tmp[2] + d[2];

                if (nh > -1 && nr > -1 && nc > -1 && nh < 5 && nr < 5 && nc < 5 && maze[nh][nr][nc] && !visit[nh][nr][nc]) {
                    visit[nh][nr][nc] = true;
                    q.offer(new int[]{nh, nr, nc, tmp[3] + 1});
                }
            }
        }
    }

    private static void rotate(boolean[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                boolean tmp = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = tmp;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                boolean tmp = map[i][j];
                map[i][j] = map[i][4 - j];
                map[i][4 - j] = tmp;
            }
        }
    }

    private static void orderBoard(int idx) {
        if (idx == 5) {
            for (int i = 0; i < 5; i++) {
                maze[i] = input[order[i]];
            }
            rotateBoard(0);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if ((bitmask & 1 << i) == 0) {
                bitmask |= 1 << i;
                order[idx] = i;
                orderBoard(idx + 1);
                bitmask &= ~(1 << i);
            }
        }
    }
}
