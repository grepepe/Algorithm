package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10026 {

    private static int n;
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        char[][] map2 = new char[n][n];

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
                map2[i][j] = map[i][j] == 'G' ? 'R' : map[i][j];
            }
        }

        sb.append(dfs(map)).append(" ").append(dfs(map2));
        System.out.print(sb);
    }

    private static int dfs(char[][] map) {

        int num = 0;
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> nextQ = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];

        nextQ.offer(new int[]{0, 0});

        while (!nextQ.isEmpty()) {

            int[] next = nextQ.poll();

            if (!visit[next[0]][next[1]]) {
                num++;
                visit[next[0]][next[1]] = true;
                q.offer(next);

                char start = map[next[0]][next[1]];

                while (!q.isEmpty()) {

                    int[] tmp = q.poll();

                    for (int[] d : dir) {

                        int nr = tmp[0] + d[0];
                        int nc = tmp[1] + d[1];

                        if (nr > -1 && nr < n && nc > -1 && nc < n && !visit[nr][nc]) {
                            if (map[nr][nc] == start) {
                                visit[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                            } else {
                                nextQ.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return num;
    }
}
