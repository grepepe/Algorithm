package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon11005 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Stack<Character> stk = new Stack<>();
        int mod = n % b;

        while (n != 0) {
            if (mod > 9) {
                stk.push((char) ('A' + mod - 10));
            } else {
                stk.push((char) (mod + '0'));
            }
            n /= b;
            mod = n % b;
        }

        while (!stk.empty()) {
            sb.append(stk.pop());
        }

        System.out.print(sb);
    }
}
