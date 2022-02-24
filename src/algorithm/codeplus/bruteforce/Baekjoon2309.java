package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2309 {

    private static final boolean[] selected = new boolean[9];
    private static final int[] candidates = new int[9];
    private static final int[] ans = new int[7];
    private static boolean find = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = Integer.parseInt(br.readLine());
        }

        select(0, 0, 0);

        Arrays.sort(ans);

        for (int a : ans) {
            sb.append(a).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void select(int cnt, int idx, int total) {
        if (cnt == 7 && total == 100) {

            int j = 0;

            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    ans[j++] = candidates[i];
                }
            }

            find = true;
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (find) {
                break;
            }
            selected[i] = true;
            select(cnt + 1, i + 1, total + candidates[i]);
            selected[i] = false;
        }
    }
}
