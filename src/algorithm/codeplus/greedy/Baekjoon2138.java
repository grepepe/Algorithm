package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2138 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 100000;
        int n = Integer.parseInt(br.readLine());
        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();
        boolean[] arr1 = new boolean[n];
        boolean[] arr2 = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = input1[i] != input2[i];
            arr2[i] = input1[i] != input2[i];
        }

        arr2[0] = !arr2[0];
        arr2[1] = !arr2[1];

        int tmp = 0;

        for (int i = 1; i < n; i++) {
            if (arr1[i - 1]) {
                arr1[i - 1] = !arr1[i - 1];
                arr1[i] = !arr1[i];
                if (i < n - 1) {
                    arr1[i + 1] = !arr1[i + 1];
                }
                tmp++;
            }
        }

        if (!arr1[n - 1]) {
            ans = Math.min(ans, tmp);
        }

        tmp = 1;

        for (int i = 1; i < n; i++) {
            if (arr2[i - 1]) {
                arr2[i - 1] = !arr2[i - 1];
                arr2[i] = !arr2[i];
                if (i < n - 1) {
                    arr2[i + 1] = !arr2[i + 1];
                }
                tmp++;
            }
        }

        if (!arr2[n - 1]) {
            ans = Math.min(ans, tmp);
        }

        System.out.print(ans == 100000 ? -1 : ans);
    }
}
