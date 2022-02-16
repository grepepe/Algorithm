package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2089 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            sb.append(0);
        }

        while (n != 0) {
            if (n % -2 == 0) {
                n /= -2;
                sb.insert(0, 0);
            } else {
                n = (n - 1) / -2;
                sb.insert(0, 1);
            }
        }

        System.out.print(sb);
    }
}
