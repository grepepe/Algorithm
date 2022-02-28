package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15663 {

    private static boolean[] selected;
    private static int[] tmp;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        selected = new boolean[input[0]];
        tmp = new int[input[1]];

        Arrays.sort(arr);

        select(input[1], arr, 0);

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void select(int m, int[] arr, int cnt) {
        if (cnt == m) {
            for (int t : tmp) {
                sb.append(t).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }

        int pre = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!selected[i] && pre != arr[i]) {
                tmp[cnt] = arr[i];
                pre = arr[i];
                selected[i] = true;
                select(m, arr, cnt + 1);
                selected[i] = false;
            }
        }
    }
}
