package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2251 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] vol = new int[3];

        br.close();

        for (int i = 0; i < 3; i++) {
            vol[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] cValue = new boolean[vol[2] + 1];
        boolean[][][] visit = new boolean[vol[0]+1][vol[1]+1][vol[2]+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, vol[2]});
        visit[0][0][vol[2]] = true;
        cValue[vol[2]] = true;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            if (tmp[0] == 0) {
                cValue[tmp[2]] = true;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j && tmp[i] > 0 && tmp[j] < vol[j]) {

                        int[] next = new int[3];
                        int sum = tmp[i] + tmp[j];

                        for (int k = 0; k < 3; k++) {
                            next[k] = tmp[k];
                        }

                        if (sum > vol[j]) {
                            next[i] = sum - vol[j];
                            next[j] = vol[j];

                        } else {
                            next[i] = 0;
                            next[j] = sum;
                        }

                        if (!visit[next[0]][next[1]][next[2]]) {
                            q.offer(next);
                            visit[next[0]][next[1]][next[2]] = true;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cValue.length; i++) {
            if (cValue[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);
    }
}
