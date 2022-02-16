package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        System.out.print(
                Math.min(getXNum(5, n) - getXNum(5, m) - getXNum(5, n - m),
                        getXNum(2, n) - getXNum(2, m) - getXNum(2, n - m)));
    }

    private static int getXNum(int x, int n) {

        int ans = 0;

        while (n > 0) {
            n /= x;
            ans += n;
        }
        return ans;
    }
}
