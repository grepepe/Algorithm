package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int LENGTH = 'z' - 'a' + 1;

        for (char c : br.readLine().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 13;
                if (c > 'Z') {
                    c -= LENGTH;
                }
                sb.append(c);
            } else if (c >= 'a' && c <= 'z') {
                c += 13;
                if (c > 'z') {
                    c -= LENGTH;
                }
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        System.out.print(sb);
    }
}
