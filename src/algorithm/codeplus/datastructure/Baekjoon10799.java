package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bar = br.readLine();
        Stack<Boolean> stk = new Stack<>();
        boolean isLaser = false;
        int ans = 0;

        for (char c : bar.toCharArray()) {
            if (c == ')') {
                stk.pop();
                if (isLaser) {
                    ans += stk.size();
                    isLaser = false;
                } else {
                    ans++;
                }
            } else {
                stk.push(true);
                isLaser = true;
            }
        }

        System.out.println(ans);
    }
}
