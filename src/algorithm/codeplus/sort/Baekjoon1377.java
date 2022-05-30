package algorithm.codeplus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon1377 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyNum[] arr = new MyNum[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new MyNum(i, Integer.parseInt(br.readLine()));
        }

        br.close();

        Arrays.sort(arr, Comparator.comparingInt(o -> o.value));

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, arr[i].idx - i + 1);
        }

        System.out.print(ans);
    }

    private static class MyNum {
        int idx;
        int value;

        public MyNum(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
