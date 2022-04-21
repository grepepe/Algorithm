package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2109 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] pd = new int[n][2];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            pd[i][0] = Integer.parseInt(st.nextToken());
            pd[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pd, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        int ans = 0;
        int endDay = n == 0 ? 0 : pd[0][1];

        while (endDay > 0) {

            while (idx < n && endDay == pd[idx][1]) {
                pq.offer(pd[idx][0]);
                idx++;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
            endDay--;
        }

        System.out.print(ans);
    }
}
