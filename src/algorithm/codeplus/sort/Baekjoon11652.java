package algorithm.codeplus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Baekjoon11652 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int valueNum = 1;
        long ans = arr[0];
        int ansNum = valueNum;

        for (int i = 1; i < n; i++) {
            if (Objects.equals(arr[i - 1], arr[i])) {
                valueNum++;
            } else {
                if (ansNum < valueNum) {
                    ansNum = valueNum;
                    ans = arr[i-1];
                }
                valueNum = 1;
            }
        }
        if (ansNum < valueNum) {
            ans = arr[n-1];
        }

        System.out.print(ans);
    }
}
