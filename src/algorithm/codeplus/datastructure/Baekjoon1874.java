package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] targets = new int[n];
        int currentNum = 1, idx = 0;
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        while (currentNum <= n) {
            stk.push(currentNum++);
            sb.append("+").append("\n");
            while (!stk.empty() && targets[idx] == stk.peek()) {
                stk.pop();
                sb.append("-").append("\n");
                idx++;
            }
        }

        if (stk.empty()) {
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
