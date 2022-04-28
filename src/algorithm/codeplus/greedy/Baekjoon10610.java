package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Integer[] arr = new Integer[input.length];
        StringBuilder ans = new StringBuilder("-1");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input[i] - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        if (arr[arr.length - 1] == 0) {

            int sum = 0;
            StringBuilder tmp = new StringBuilder();

            for (int i = 0; i < arr.length - 1; i++) {
                sum += arr[i];
                tmp.append(arr[i]);
            }

            if (sum % 3 == 0) {
                ans = new StringBuilder(tmp);
                ans.append(0);
            }
        }

        System.out.print(ans);
    }
}
