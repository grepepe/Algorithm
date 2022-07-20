package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baekjoon16638 {


    private static int n;
    private static char[] input;
    private static boolean[] parenthesis;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parenthesis = new boolean[n];
        input = br.readLine().toCharArray();
        br.close();

        dfs(1);

        System.out.print(ans);
    }

    private static void dfs(int idx) {
        if (idx >= n) {
            ans = Math.max(ans, postfix());
            return;
        }

        dfs(idx + 2);
        parenthesis[idx] = true;
        dfs(idx + 4);
        parenthesis[idx] = false;
    }

    private static int postfix() {

        List<Character> exp = new ArrayList<>();
        Stack<Character> opStk = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (input[i] >= '0' && input[i] <= '9') {
                exp.add(input[i]);
            } else {
                if (parenthesis[i]) {
                    exp.add(input[i+1]);
                    exp.add(input[i++]);
                } else {
                    while (!opStk.isEmpty() && !(input[i] == '*' && opStk.peek() != '*')) {
                        exp.add(opStk.pop());
                    }
                    opStk.push(input[i]);
                }
            }
        }

        while (!opStk.isEmpty()) {
            exp.add(opStk.pop());
        }

        Stack<Integer> numStk = new Stack<>();

        for (char e : exp) {
            if (e >= '0' && e <= '9') {
                numStk.push(e - '0');
            } else {
                numStk.push(calculate(e, numStk.pop(), numStk.pop()));
            }
        }

        return numStk.pop();
    }

    private static int calculate(char op, int a, int b) {

        int result = 0;

        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
        }
        return result;
    }
}
