package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        int left = 1;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        br.close();

        int ans = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (getLength(trees, mid) < m) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }

    private static long getLength(int[] trees, int cutLength) {

        long length = 0;

        for (int tree : trees) {
            length += tree <= cutLength ? 0 : tree - cutLength;
        }

        return length;
    }
}
