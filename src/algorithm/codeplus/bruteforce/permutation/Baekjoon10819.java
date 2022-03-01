package algorithm.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10819 {

    private static final StringBuilder sb = new StringBuilder();
    private static boolean[] selected;
    private static int[] perm;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        selected = new boolean[n];
        perm = new int[n];

        Arrays.sort(arr);

        searchAns(n, arr, 0);

        System.out.print(ans);
    }

    private static void searchAns(int n, int[] arr, int cnt) {
        if (cnt == n) {

            int tmp = 0;

            for (int i = 1; i < n; i++) {
                tmp += Math.abs(perm[i-1] - perm[i]);
            }

            ans = Math.max(ans, tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                perm[cnt] = arr[i];
                searchAns(n, arr, cnt + 1);
                selected[i] = false;
            }
        }
    }
}
