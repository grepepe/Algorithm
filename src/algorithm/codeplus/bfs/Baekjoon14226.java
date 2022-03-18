package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon14226 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        boolean[][] visit = new boolean[1001][1001];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{1, 0, 0});
        visit[1][0] = true;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == s) {
                System.out.print(tmp[2]);
                break;
            }

            if (!visit[tmp[0]][tmp[0]]) {
                q.offer(new int[]{tmp[0], tmp[0], tmp[2] + 1});
                visit[tmp[0]][tmp[0]] = true;
            }
            if (tmp[0] > 3 && !visit[tmp[0] - 1][tmp[1]]) {
                q.offer(new int[]{tmp[0] - 1, tmp[1], tmp[2] + 1});
                visit[tmp[0] - 1][tmp[1]] = true;
            }
            if (tmp[0] + tmp[1] < visit.length && !visit[tmp[0] + tmp[1]][tmp[1]]) {
                q.offer(new int[]{tmp[0] + tmp[1], tmp[1], tmp[2] + 1});
                visit[tmp[0] + tmp[1]][tmp[1]] = true;
            }
        }
    }
}