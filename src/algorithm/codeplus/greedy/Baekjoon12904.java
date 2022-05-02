package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());
        int num = t.length() - s.length();
        int tLen = t.length();

        for (int i = 0; i < num; i++) {

            char tmp = t.charAt(--tLen);

            t.deleteCharAt(tLen);

            if (tmp == 'B') {
                t.reverse();
            }
        }

        if (s.equals(t.toString())) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
