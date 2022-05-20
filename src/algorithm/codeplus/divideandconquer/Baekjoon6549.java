package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon6549 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            long[] histogram = new long[n];

            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getMaxArea(histogram, 0, n - 1)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static long getMaxArea(long[] histogram, int left, int right) {

        if (left == right) {
            return histogram[left];
        } else {

            int mid = (left + right) / 2;
            long leftArea = getMaxArea(histogram, left, mid);
            long rightArea = getMaxArea(histogram, mid + 1, right);
            long height = Math.min(histogram[mid], histogram[mid + 1]);
            long width = 2;
            long area = width * height;
            int i = mid - 1;
            int j = mid + 2;

            while (i >= left && j <= right) {
                width++;
                if (histogram[i] < histogram[j]) {
                    height = Math.min(height, histogram[j]);
                    area = Math.max(area, width * height);
                    j++;
                } else {
                    height = Math.min(height, histogram[i]);
                    area = Math.max(area, width * height);
                    i--;
                }
            }

            while (i >= left) {
                width++;
                height = Math.min(height, histogram[i]);
                area = Math.max(area, width * height);
                i--;
            }

            while (j <= right) {
                width++;
                height = Math.min(height, histogram[j]);
                area = Math.max(area, width * height);
                j++;
            }

            return Math.max(area, Math.max(leftArea, rightArea));
        }
    }
}
