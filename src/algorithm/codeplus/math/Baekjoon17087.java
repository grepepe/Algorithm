package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17087 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int ans = Math.abs(Integer.parseInt(st.nextToken()) - s);

        while (n-- > 1) {
            ans = getGCD(ans, Math.abs(Integer.parseInt(st.nextToken()) - s));
        }

        System.out.print(ans);
    }

    private static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
