package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1790 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        br.close();

        System.out.print(binarySearch(1, n, k));
    }

    private static int binarySearch(int left, int right, int k) {

        int tmp = -1;

        while (left <= right) {

            int mid = (left + right) / 2;
            int idx = getIdx(mid);

            if (idx < k) {
                left = mid + 1;
            } else {
                tmp = mid;
                right = mid - 1;
            }
        }

        int ans = tmp;

        if (tmp != 0) {
            int pos = getIdx(tmp) - k;
            int digit = 1;

            for (int i = 0; i < pos; i++) {
                digit *= 10;
            }

            ans %= (10 * digit);
            ans /= digit;
        }

        return ans;
    }

    private static int getIdx(int num) {

        int start = 1;
        int end = 9;
        int digit = 1;
        int ans = 0;

        while (true) {
            if (end > num) {
                ans += ((num - start) + 1) * digit;
                break;
            } else {
                ans += ((end - start) + 1) * digit;
            }
            start *= 10;
            end = 10 * start - 1;
            digit++;
        }

        return ans;
    }
}
