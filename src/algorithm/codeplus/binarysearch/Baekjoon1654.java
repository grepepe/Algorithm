package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lanLines = new int[k];
        long left = 1;
        long right = 0;

        for (int i = 0; i < k; i++) {
            lanLines[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lanLines[i]);
        }

        br.close();

        int ans = -1;

        while (left <= right) {

            long mid = (left + right) / 2;

            if (getNum(lanLines, (int) mid) < n) {
                right = mid - 1;
            } else {
                ans = (int) mid;
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }

    private static int getNum(int[] arr, int tmp) {

        int num = 0;

        for (int a : arr) {
            num += a / tmp;
        }

        return num;
    }
}
