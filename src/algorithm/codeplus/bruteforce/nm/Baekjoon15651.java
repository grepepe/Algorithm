package algorithm.codeplus.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon15651 {

    private static final StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new int[input[1]];

        select(input[0], input[1], 0);

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void select(int n, int m, int cnt) {
        if (cnt == m) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[cnt] = i;
            select(n, m, cnt+1);
        }
    }
}
