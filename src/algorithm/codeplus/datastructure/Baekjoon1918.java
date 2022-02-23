package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1918 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp  = br.readLine();
        Stack<Character> op = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : exp.toCharArray()) {
            if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(') {
                    sb.append(op.pop());
                }
                op.pop();
            } else if (c == '+' || c == '-') {
                while (!op.empty() && op.peek() != '(') {
                    sb.append(op.pop());
                }
                op.push(c);
            } else if (c == '*' || c == '/') {
                while (!op.empty() && (op.peek() == '*' || op.peek() == '/')) {
                    sb.append(op.pop());
                }
                op.push(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            }
        }
        while(!op.empty()){
            sb.append(op.pop());
        }

        System.out.print(sb);
    }
}
