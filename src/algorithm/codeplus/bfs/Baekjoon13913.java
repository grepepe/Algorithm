package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon13913 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        int[] pre = new int[100001];
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        q.offer(new int[]{n, 0});
        visit[n] =true;
        pre[n] = -1;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            int[] next = new int[3];

            if (tmp[0] == k) {

                int idx = k;

                sb.append(tmp[1]).append("\n");
                while (idx != -1) {
                    stk.push(idx);
                    idx = pre[idx];
                }
                break;
            }

            next[0] = tmp[0] * 2;
            next[1] = tmp[0] - 1;
            next[2] = tmp[0] + 1;

            for (int ne : next) {
                if (ne > -1 && ne < visit.length && !visit[ne]) {
                    visit[ne] = true;
                    pre[ne] = tmp[0];
                    q.offer(new int[]{ne, tmp[1] + 1});
                }
            }
        }

        while (!stk.empty()) {
            sb.append(stk.pop()).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
