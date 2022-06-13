package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13397 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        br.close();

        int ans = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (getSectionNum(arr, mid) > m) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    private static int getSectionNum(int[] arr, int limit) {

        int num = 1;
        int min = arr[0];
        int max = arr[0];

        for (int i=1; i<arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > limit) {
                num++;
                min = arr[i];
                max = arr[i];
            }
        }

        return num;
    }
}
