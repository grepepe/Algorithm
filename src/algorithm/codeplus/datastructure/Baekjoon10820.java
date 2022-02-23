package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10820 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        int lower, upper, num, space;

        while ((s = br.readLine()) != null) {
            lower = 0;
            upper = 0;
            num = 0;
            space = 0;

            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    lower++;
                } else if (c >= 'A' && c <= 'Z') {
                    upper++;
                } else if (c >= '0' && c <= '9') {
                    num++;
                } else if (c == ' ') {
                    space++;
                }
            }

            sb.append(lower).append(" ").append(upper).append(" ").append(num).append(" ").append(space).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
