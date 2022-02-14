package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1406 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());
        Stack<Character> leftStk = new Stack<>();
        Stack<Character> rightStk = new Stack<>();

        for (char s : str.toCharArray()) {
            leftStk.push(s);
        }

        while (m-- > 0) {

            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (!leftStk.empty()) {
                        rightStk.push(leftStk.pop());
                    }
                    break;
                case 'D':
                    if (!rightStk.empty()) {
                        leftStk.push(rightStk.pop());
                    }
                    break;
                case 'B':
                    if (!leftStk.empty()) {
                        leftStk.pop();
                    }
                    break;
                case 'P':
                    leftStk.push(command.charAt(2));
            }
        }

        while (!leftStk.empty()) {
            rightStk.push(leftStk.pop());
        }

        while (!rightStk.empty()) {
            sb.append(rightStk.pop());
        }

        System.out.println(sb);
    }
}
