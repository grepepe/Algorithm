package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon12886 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stones = new int[3];
        int ans = 0;

        for (int i = 0; i < stones.length; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stones);

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[1501][1501];

        visit[stones[0]][stones[1]] = true;
        q.offer(stones);

        while (!q.isEmpty()) {

            int[] tmpStone = q.poll().clone();

            if (tmpStone[0] == tmpStone[1] && tmpStone[1] == tmpStone[2]) {
                ans = 1;
                break;
            }

            int[] tmp;

            tmp = new int[]{tmpStone[0] + tmpStone[0], tmpStone[1] - tmpStone[0], tmpStone[2]};
            Arrays.sort(tmp);
            if (!visit[tmp[0]][tmp[1]]) {
                visit[tmp[0]][tmp[1]] = true;
                q.offer(tmp);
            }

            tmp = new int[]{tmpStone[0] + tmpStone[0], tmpStone[1], tmpStone[2] - tmpStone[0]};
            Arrays.sort(tmp);
            if (!visit[tmp[0]][tmp[1]]) {
                visit[tmp[0]][tmp[1]] = true;
                q.offer(tmp);
            }

            tmp = new int[]{tmpStone[0], tmpStone[1] + tmpStone[1], tmpStone[2] - tmpStone[1]};
            Arrays.sort(tmp);
            if (!visit[tmp[0]][tmp[1]]) {
                visit[tmp[0]][tmp[1]] = true;
                q.offer(tmp);
            }
        }

        System.out.print(ans);
    }
}
