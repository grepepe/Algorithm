package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon11576 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stk = new Stack<>();
        int deci = 0;

        for (int i = 0; i < m; i++) {
            deci *= a;
            deci += Integer.parseInt(st.nextToken());
        }

        while (deci != 0) {
            stk.push(deci % b);
            deci /= b;
        }

        while (!stk.empty()) {
            sb.append(stk.pop()).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
