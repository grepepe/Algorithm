package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1074 {

    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = 1;

        for (int i = 0; i < n; i++) {
            size *= 2;
        }

        getNum(size / 2, r, c);

        System.out.print(ans);
        br.close();
    }

    private static void getNum(int half, int r, int c) {
        if (half > 0) {
            if (r >= half) {
                if (c >= half) {
                    ans += 3 * half * half;
                    getNum(half / 2, r - half, c - half);
                } else {
                    ans += 2 * half * half;
                    getNum(half / 2, r - half, c);
                }
            } else {
                if (c >= half) {
                    ans += half * half;
                    getNum(half / 2, r, c - half);
                } else {
                    getNum(half / 2, r, c);
                }
            }
        }
    }
}
