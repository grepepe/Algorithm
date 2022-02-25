package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1476 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] date = new int[3];
        int ans = 1;

        for (int i = 0; i < date.length; i++) {
            date[i] = Integer.parseInt(st.nextToken());
        }

        while (ans % 15 != date[0] % 15 || ans % 28 != date[1] % 28 || ans % 19 != date[2] % 19) {
            ans++;
        }

        System.out.println(ans);
    }

}
