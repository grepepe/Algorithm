package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<Integer> groupNum = new ArrayList<>();
        int[][] group = new int[n][m];
        final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        boolean[][] visit = new boolean[n][m];
        int num = 1;

        groupNum.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {

                    Queue<int[]> q = new LinkedList<>();
                    int cnt = 0;

                    visit[i][j] = true;
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {

                        int[] tmp = q.poll();

                        group[tmp[0]][tmp[1]] = num;
                        cnt++;

                        for (int[] d : dir) {

                            int nr = tmp[0] + d[0];
                            int nc = tmp[1] + d[1];

                            if (nr > -1 && nr < n && nc > -1 && nc < m && map[nr][nc] == 0 && !visit[nr][nc]) {
                                visit[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    num++;
                    groupNum.add(cnt);
                }
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {

                    Set<Integer> selected = new HashSet<>();

                    for (int[] d : dir) {

                        int nr = i + d[0];
                        int nc = j + d[1];

                        if (nr > -1 && nr < n && nc > -1 && nc < m && !selected.contains(group[nr][nc])) {
                            selected.add(group[nr][nc]);
                            map[i][j] += groupNum.get(group[nr][nc]);
                        }
                    }

                    map[i][j] %= 10;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
