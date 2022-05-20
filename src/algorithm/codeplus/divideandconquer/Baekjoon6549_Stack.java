package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon6549_Stack {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            long[] histogram = new long[n];
            Stack<Integer> stk = new Stack<>();

            for (int i = 0; i < n; i++) {
                histogram[i] = Long.parseLong(st.nextToken());
            }

            long ans = 0;

            for (int i = 0; i < n; i++) {
                while (!stk.isEmpty() && histogram[stk.peek()] > histogram[i]) {

                    long height = histogram[stk.pop()];
                    int width = stk.isEmpty() ? i : i - stk.peek() - 1;

                    ans = Math.max(ans, width * height);
                }
                stk.push(i);
            }

            while (!stk.isEmpty()) {

                long height = histogram[stk.pop()];
                int width = stk.isEmpty() ? n : n - stk.peek() - 1;

                ans = Math.max(ans, width * height);
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
