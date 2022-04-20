package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1202 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] jewels = new int[n][2];
        int[] bag = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        Arrays.sort(jewels, Comparator.comparingInt(o->o[0]));
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        long ans = 0;

        for (int i = 0; i < k; i++) {
            while (idx < n && bag[i] >= jewels[idx][0]) {
                pq.offer(jewels[idx][1]);
                idx++;
            }
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.print(ans);
    }
}
