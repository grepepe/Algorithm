package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int ans = 0;

        while (!isZero(arr)) {

            boolean allZero = true;

            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 1) {
                    arr[i]--;
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                for (int i = 0; i < n; i++) {
                    arr[i] /= 2;
                }
            }

            ans++;
        }

        System.out.print(ans);

    }

    private static boolean isZero(int[] arr) {
        for (int a : arr) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
