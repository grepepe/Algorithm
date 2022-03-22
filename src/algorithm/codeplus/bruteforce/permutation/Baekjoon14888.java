package algorithm.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14888 {

    private static int n;
    private static int[] arr;
    private static final int[] op = new int[4];
    private static int min = 1000000000;
    private static int max = -1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.print(max + "\n" + min);
    }

    private static void dfs(int idx, int result) {
        if (idx == n) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        dfs(idx + 1, result + arr[idx]);
                        break;
                    case 1:
                        dfs(idx + 1, result - arr[idx]);
                        break;
                    case 2:
                        dfs(idx + 1, result * arr[idx]);
                        break;
                    case 3:
                        dfs(idx + 1, result / arr[idx]);
                        break;
                }
                op[i]++;
            }
        }
    }
}
