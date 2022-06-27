package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16917 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        br.close();

        int totalPrice = a * x + b * y;
        int halfHalfMaxCnt = 2 * Math.max(x, y);

        for (int i = 2; i <= halfHalfMaxCnt; i += 2) {
            totalPrice = Math.min(totalPrice, a * Math.max((x - i / 2), 0) + b * Math.max((y - i / 2), 0) + c * i);
        }

        System.out.print(totalPrice);
    }
}
