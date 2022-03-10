package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon4963 {

    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    private static int w, h;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String[] inputs = br.readLine().split(" ");
            int ans = 0;

            if (inputs[0].equals("0") && inputs[1].equals("0")) {
                break;
            }

            w = Integer.parseInt(inputs[0]);
            h = Integer.parseInt(inputs[1]);
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {

                inputs = br.readLine().split(" ");

                for (int j = 0; j < w; j++) {
                    if (Integer.parseInt(inputs[j]) == 0) {
                        visit[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j]) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.print(sb);
    }

    private static void bfs(int r, int c) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r, c});
        visit[r][c] = true;

        while (!q.isEmpty()) {

            int tmpR = q.peek()[0];
            int tmpC = q.poll()[1];

            for (int[] d : dir) {

                int newR = tmpR + d[0];
                int newC = tmpC + d[1];

                if (newR > -1 && newR < h && newC > -1 && newC < w && !visit[newR][newC]) {
                    visit[newR][newC] = true;
                    q.offer(new int[]{newR, newC});
                }
            }
        }
    }
}
