package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1212 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String oNum = br.readLine();

        for (char o : oNum.toCharArray()) {

            int num = o - '0';
            char[] tmp = new char[3];

            for (int i = 2; i > -1; i--) {
                tmp[i] = (char)(num % 2 + '0');
                num /= 2;
            }

            sb.append(tmp);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        System.out.print(sb);
    }
}
