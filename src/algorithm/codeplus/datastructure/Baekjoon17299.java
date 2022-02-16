package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17299 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            map.put(seq[i], map.getOrDefault(seq[i], 0) + 1);
        }

        stk.push(0);
        for (int i = 1; i < n; i++) {
            while (!stk.empty() && map.get(seq[i]) > map.get(seq[stk.peek()])) {
                ans[stk.pop()] = seq[i];
            }
            stk.push(i);
        }

        while (!stk.empty()) {
            ans[stk.pop()] = -1;
        }

        for (int a : ans) {
            sb.append(a).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
