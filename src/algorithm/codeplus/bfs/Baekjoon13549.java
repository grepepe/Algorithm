package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13549 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visit = new boolean[100001];

        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            visit[tmp[0]] = true;

            if (tmp[0] == k) {
                System.out.print(tmp[1]);
                break;
            }

            if (tmp[0] * 2 < visit.length && !visit[tmp[0] * 2]) {
                q.offer(new int[]{tmp[0] * 2, tmp[1]});
            }
            if (tmp[0] + 1 < visit.length && !visit[tmp[0] + 1]) {
                q.offer(new int[]{tmp[0] + 1, tmp[1] + 1});
            }
            if (tmp[0] - 1 > -1 && !visit[tmp[0] - 1]) {
                q.offer(new int[]{tmp[0] - 1, tmp[1] + 1});
            }
        }
    }
}
