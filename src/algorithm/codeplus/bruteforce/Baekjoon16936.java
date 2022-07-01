package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16936 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        br.close();

        Queue<Array> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            List<Long> arr = new ArrayList<>();
            boolean[] visit = new boolean[n];

            arr.add(b[i]);
            visit[i] = true;
            q.offer(new Array(arr, visit));
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {

            List<Long> tmpArr = q.peek().arr;
            boolean[] tmpVisit = q.poll().visit;

            if (tmpArr.size() == n) {
                for (long a : tmpArr) {
                    sb.append(a).append(" ");
                }
                break;
            }

            Long lastNum = tmpArr.get(tmpArr.size() - 1);

            for (int i = 0; i < n; i++) {
                if (!tmpVisit[i]) {
                    if ((lastNum % 3 == 0 && lastNum / 3 == b[i]) || lastNum * 2 == b[i]) {
                        tmpArr.add(b[i]);
                        tmpVisit[i] = true;
                        q.offer(new Array(tmpArr, tmpVisit));
                    }
                }
            }

        }

        System.out.print(sb);
    }

    private static class Array {

        List<Long> arr;
        boolean[] visit;

        public Array(List<Long> arr, boolean[] visit) {
            this.arr = arr;
            this.visit = visit;
        }
    }
}
