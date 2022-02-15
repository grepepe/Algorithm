package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17298 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] seq = new int[n];
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> ans = new Stack<>();


        for (int i=n-1; i>-1; i--) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int s : seq) {
            while (!stk.empty() && stk.peek() <= s) {
                stk.pop();
            }
            if (stk.empty()) {
                ans.push(-1);
            } else {
                ans.push(stk.peek());
            }
            stk.push(s);
        }

        while (!ans.empty()) {
            sb.append(ans.pop()).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
