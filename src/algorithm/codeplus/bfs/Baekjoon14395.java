package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14395 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        Queue<Pair> q = new LinkedList<>();
        Set<Long> visit = new HashSet<>();
        String ans = "-1";

        visit.add(s);
        q.offer(new Pair(s, ""));
        visit.add(1L);
        q.offer(new Pair(1, "/"));

        while (!q.isEmpty()) {

            Pair tmp = q.poll();

            if (tmp.num == t) {
                ans = tmp.op;
                break;
            }

            long tmpNum = tmp.num * tmp.num;

            if (tmpNum < 1000000001L && tmpNum > 0 && !visit.contains(tmpNum)) {
                visit.add(tmpNum);
                q.offer(new Pair(tmpNum, tmp.op + "*"));
            }

            tmpNum = tmp.num + tmp.num;

            if (tmpNum < 1000000001L && tmpNum > 0 && !visit.contains(tmpNum)) {
                visit.add(tmpNum);
                q.offer(new Pair(tmpNum, tmp.op + "+"));
            }
        }
        System.out.print(ans.equals("") ? 0 : ans);
    }

    private static class Pair {
        long num;
        String op;

        public Pair(long num, String op) {
            this.num = num;
            this.op = op;
        }
    }
}
