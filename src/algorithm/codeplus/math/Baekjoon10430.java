package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10430 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] params = new int[3];

        for (int i = 0; i < params.length; i++) {
            params[i] = Integer.parseInt(st.nextToken());
        }

        sb.append((params[0] + params[1]) % params[2]).append("\n");
        sb.append(((params[0] % params[2]) + (params[1] % params[2]))%params[2]).append("\n");
        sb.append((params[0] * params[1]) % params[2]).append("\n");
        sb.append(((params[0] % params[2]) * (params[1] % params[2]))%params[2]);

        System.out.println(sb);
    }
}
