package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1748 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dec = 1;
        int tmp = n;
        int ans = 0;
        int i = 1;

        while (tmp / 10 != 0) {
            ans += 9 * i * dec;
            i++;
            dec *= 10;
            tmp /= 10;
        }

        ans += (n - dec + 1) * i;

        System.out.print(ans);
    }

}
