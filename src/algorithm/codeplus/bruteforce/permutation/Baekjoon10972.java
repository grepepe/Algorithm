package algorithm.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10972 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int tmp, idx;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                idx = i;
                for (int j = i+1; j < n; j++) {
                    if (arr[i-1] < arr[j] && arr[idx] > arr[j]) {
                        idx = j;
                    }
                }

                tmp = arr[idx];
                arr[idx] = arr[i - 1];
                arr[i-1] = tmp;

                Arrays.sort(arr, i, n);

                for (int a : arr) {
                    sb.append(a).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                break;
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        System.out.print(sb);
    }
}
