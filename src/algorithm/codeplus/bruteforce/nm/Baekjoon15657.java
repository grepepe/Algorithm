package algorithm.codeplus.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon15657 {

    private static int[] tmp;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        tmp = new int[input[1]];

        Arrays.sort(arr);

        select(input[0], input[1], arr, 0, 0);

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void select(int n, int m, int[] arr, int current, int cnt) {
        if (cnt == m) {
            for (int t : tmp) {
                sb.append(t).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }
        for (int i = current; i < n; i++) {
            tmp[cnt] = arr[i];
            select(n, m, arr, i, cnt+1);
        }
    }
}
