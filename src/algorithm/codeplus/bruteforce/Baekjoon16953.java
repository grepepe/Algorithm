package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();

        Queue<long[]> q = new LinkedList<>();
        long ans = -1;

        q.offer(new long[]{a, 1});

        while (!q.isEmpty()) {

            long[] poll = q.poll();

            if (poll[0] == b) {
                ans = poll[1];
                break;
            }

            long tmp = 2 * poll[0];

            if (tmp <= b) {
                q.offer(new long[]{tmp, poll[1] + 1});
            }

            tmp = poll[0] * 10 + 1;

            if (tmp <= b) {
                q.offer(new long[]{tmp, poll[1] + 1});
            }
        }

        System.out.print(ans);
    }
}
