package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15658 {

    private static int n;
    private static int[] arr;
    private static final int[] op = new int[4];
    private static int max = -1000000000;
    private static int min = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        findAns(1, arr[0]);

        System.out.print(max + "\n" + min);
    }

    private static void findAns(int idx, int result) {
        if (idx == n) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }
        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        findAns(idx + 1, result + arr[idx]);
                        break;
                    case 1:
                        findAns(idx + 1, result - arr[idx]);
                        break;
                    case 2:
                        findAns(idx + 1, result * arr[idx]);
                        break;
                    case 3:
                        findAns(idx + 1, result / arr[idx]);
                        break;
                }
                op[i]++;
            }
        }
    }
}
