package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon12919 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        Queue<String> q = new LinkedList<>();
        int ans = 0;

        q.offer(t);

        while (!q.isEmpty()) {

            String tmp = q.poll();

            if (tmp.length() == s.length()) {
                if (tmp.equals(s)) {
                    ans = 1;
                    break;
                }
                continue;
            }
            if (tmp.charAt(tmp.length() - 1) == 'A') {
                q.offer(tmp.substring(0, tmp.length() - 1));
            }
            if (tmp.charAt(0) == 'B') {
                q.offer(new StringBuilder(tmp.substring(1)).reverse().toString());
            }
        }

        System.out.print(ans);
    }
}
