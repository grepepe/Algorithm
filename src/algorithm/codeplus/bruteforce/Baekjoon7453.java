package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon7453 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] list = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i * n + j] = a[i] + b[j];
            }
        }

        Arrays.sort(list);

        long ans = 0;

        for (int cv : c) {
            for (int dv : d) {
                int tmp = -(cv + dv);

                ans += upperBound(list, tmp) - lowerBound(list, tmp);
            }
        }

        System.out.print(ans);
    }

    private static int lowerBound(int[] list, int target) {

        int left = 0;
        int right = list.length;
        int mid;

        while (left < right) {

            mid = (left + right) / 2;

            if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int upperBound(int[] list, int target) {

        int left = 0;
        int right = list.length;
        int mid;

        while (left < right) {

            mid = (left + right) / 2;

            if (list[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
