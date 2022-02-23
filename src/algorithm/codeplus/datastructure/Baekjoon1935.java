package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String exp = br.readLine();
        double[] vars = new double[n];
        Stack<Double> stk = new Stack<>();
        double tmp;

        for (int i = 0; i < n; i++) {
            vars[i] = Double.parseDouble(br.readLine());
        }

        for (char c : exp.toCharArray()) {
            switch (c) {
                case '+':
                    tmp = stk.pop();
                    tmp += stk.pop();
                    stk.push(tmp);
                    break;
                case '-':
                    tmp = stk.pop();
                    stk.push(stk.pop() - tmp);
                    break;
                case '*':
                    tmp = stk.pop();
                    tmp *= stk.pop();
                    stk.push(tmp);
                    break;
                case '/':
                    tmp = stk.pop();
                    stk.push(stk.pop() / tmp);
                    break;
                default:
                    stk.push(vars[c - 'A']);
                    break;
            }
        }

        System.out.printf("%.2f", stk.pop());
    }
}
