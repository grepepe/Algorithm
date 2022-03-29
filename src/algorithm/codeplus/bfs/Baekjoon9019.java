package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baekjoon9019 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (t-- != 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            Queue<DSLR> q = new LinkedList<>();
            boolean[] visit = new boolean[10000];

            visit[start] = true;
            q.offer(new DSLR(start, ""));

            while (!q.isEmpty()) {

                DSLR next = q.poll();
                int tmp;

                if (goal == next.num) {
                    ans.append(next.cmd).append("\n");
                    break;
                }

                tmp = next.num * 2 % 10000;
                if (!visit[tmp]) {
                    q.offer(new DSLR(tmp, next.cmd + 'D'));
                    visit[tmp] = true;
                }

                tmp = next.num > 0 ? next.num - 1 : 9999;
                if (!visit[tmp]) {
                    q.offer(new DSLR(tmp, next.cmd + 'S'));
                    visit[tmp] = true;
                }

                tmp = (next.num % 1000) * 10 + (next.num / 1000);
                if (!visit[tmp]) {
                    q.offer(new DSLR(tmp, next.cmd + 'L'));
                    visit[tmp] = true;
                }

                tmp = (next.num % 10) * 1000 + (next.num / 10);
                if (!visit[tmp]) {
                    q.offer(new DSLR(tmp, next.cmd + 'R'));
                    visit[tmp] = true;
                }

            }
        }

        ans.deleteCharAt(ans.length() - 1);
        System.out.print(ans);
    }

    private static class DSLR {

        public int num;
        public String cmd;

        public DSLR(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
}
