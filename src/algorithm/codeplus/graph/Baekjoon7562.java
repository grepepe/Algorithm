package algorithm.codeplus.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        final int[][] dir = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        while (t-- > 0) {

            int l = Integer.parseInt(br.readLine());
            boolean[][] visit = new boolean[l][l];
            int[] start, end;
            StringTokenizer st = new StringTokenizer(br.readLine());

            start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            Queue<int[]> q = new LinkedList<>();

            visit[start[0]][start[1]] = true;
            q.offer(new int[]{start[0], start[1], 0});

            while (!q.isEmpty()) {

                int[] tmp = q.poll();

                if (tmp[0] == end[0] && tmp[1] == end[1]) {
                    sb.append(tmp[2]).append("\n");
                    break;
                }

                for (int[] d : dir) {

                    int r = tmp[0] + d[0];
                    int c = tmp[1] + d[1];

                    if (r > -1 && r < l && c > -1 && c < l && !visit[r][c]) {
                        visit[r][c] = true;
                        q.offer(new int[]{r, c, tmp[2] + 1});
                    }
                }
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
