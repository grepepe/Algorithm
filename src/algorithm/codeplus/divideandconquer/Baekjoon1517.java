package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1517 {

    private static int[] arr;
    private static long ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        getSwapNum(0, n - 1);

        System.out.print(ans);
    }

    private static void getSwapNum(int start, int end) {

        if (start < end) {

            int mid = (start + end) / 2;

            getSwapNum(start, mid);
            getSwapNum(mid + 1, end);
            calculateSwapNum(start, mid, end);
        }
    }

    private static void calculateSwapNum(int start, int mid, int end) {

        int[] tmp = new int[end - start + 1];
        int idx = 0;
        int frontStart = start;
        int backStart = mid + 1;
        int swap = 0;

        while (frontStart <= mid && backStart <= end) {
            if (arr[frontStart] <= arr[backStart]) {
                tmp[idx++] = arr[frontStart];
                ans += swap;
                frontStart++;
            } else {
                tmp[idx++] = arr[backStart];
                swap++;
                backStart++;
            }
        }

        while (frontStart <= mid) {
            tmp[idx++] = arr[frontStart];
            ans += swap;
            frontStart++;
        }

        while (backStart <= end) {
            tmp[idx++] = arr[backStart];
            backStart++;
        }

        idx = 0;

        for (int i = start; i <= end; i++) {
            arr[i] = tmp[idx++];
        }
    }
}
