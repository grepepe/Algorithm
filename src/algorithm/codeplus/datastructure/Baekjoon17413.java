package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon17413 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stk = new Stack<>();
        int i = 0;

        while (i < chars.length) {
            if (chars[i] == '<') {
                while (!stk.empty()) {
                    sb.append(stk.pop());
                }
                while (chars[i] != '>') {
                    sb.append(chars[i++]);
                }
                sb.append(chars[i++]);
            } else if (chars[i] == ' ') {
                while (!stk.empty()) {
                    sb.append(stk.pop());
                }
                sb.append(chars[i++]);
            } else {
                stk.push(chars[i++]);
            }
        }
        while (!stk.empty()) {
            sb.append(stk.pop());
        }

        System.out.println(sb);
    }
}
