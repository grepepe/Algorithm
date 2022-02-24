package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2745 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int ans = 0;

        for (char c : n.toCharArray()) {
            ans *= b;
            if (c >= 'A' && c <= 'Z') {
                ans += (c - 'A' + 10);
            } else {
                ans += c - '0';
            }
        }

        System.out.print(ans);
    }
}
