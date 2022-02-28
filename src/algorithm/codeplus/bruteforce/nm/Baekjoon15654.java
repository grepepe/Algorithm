package algorithm.codeplus.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon15654 {

    private static int[] tmp;
    private static boolean[] selected;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        selected = new boolean[nm[0]];
        tmp = new int[nm[1]];

        Arrays.sort(arr);

        select(nm[0], nm[1], arr, 0);

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void select(int n, int m, int[] arr, int cnt) {
        if (cnt == m) {
            for (int t : tmp) {
                sb.append(t).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                tmp[cnt] = arr[i];
                selected[i] = true;
                select(n, m, arr, cnt + 1);
                selected[i] = false;
            }
        }
    }
}
