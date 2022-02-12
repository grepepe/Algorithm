package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9093 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                sb.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }

        System.out.println(sb);
    }
}
