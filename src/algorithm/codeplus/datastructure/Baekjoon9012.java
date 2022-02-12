package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String ps = br.readLine();
            Stack<Boolean> stk = new Stack<>();
            boolean isValid = true;

            for (char p : ps.toCharArray()) {
                if (p == '(') {
                    stk.push(true);
                } else {
                    if (stk.empty()) {
                        isValid = false;
                        break;
                    }
                    stk.pop();
                }
            }

            if (isValid && stk.empty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
