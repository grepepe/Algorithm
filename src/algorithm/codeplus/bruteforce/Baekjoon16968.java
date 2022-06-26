package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon16968 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        br.close();

        char before = input[0];
        int ans = before == 'c' ? 26 : 10;

        for (int i = 1; i < input.length; i++) {
            if (before == input[i]) {
                ans *= input[i] == 'c' ? 25 : 9;
            } else {
                ans *= input[i] == 'c' ? 26 : 10;
            }
            before = input[i];
        }

        System.out.print(ans);
    }
}
