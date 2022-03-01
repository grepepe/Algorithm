package algorithm.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6603 {

    private static int[] comb;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int k;
        int[] arr;

        while (true) {
            input = br.readLine().split(" ");
            if (input[0].equals("0")) {
                break;
            }
            k = Integer.parseInt(input[0]);
            arr = new int[input.length - 1];
            comb = new int[6];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input[i + 1]);
            }

            comb6(k, arr, 0, 0);

            sb.append("\n");
        }

        sb.delete((sb.length() - 2), (sb.length()));
        System.out.print(sb);
    }

    private static void comb6(int k, int[] arr, int cnt, int cur) {
        if (cnt == 6) {
            for (int c : comb) {
                sb.append(c).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            comb[cnt] = arr[i];
            comb6(k, arr, cnt + 1, i + 1);
        }
    }
}
