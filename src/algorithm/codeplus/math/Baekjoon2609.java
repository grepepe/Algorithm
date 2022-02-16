package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int gcd = getGcd(a, b);
        int lcm = a * b / gcd;

        sb.append(gcd).append("\n").append(lcm);

        System.out.println(sb);
    }

    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a%b);
    }
}
