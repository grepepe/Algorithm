package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16971 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[] rowSums = new int[n];
        int[] colSums = new int[m];

        for (int i = 0; i < n; i++) {
            rowSums[i] += a[i][0];
            for (int j = 1; j < m - 1; j++) {
                rowSums[i] += a[i][j] * 2;
            }
            rowSums[i] += a[i][m - 1];
        }

        for (int i = 0; i < m; i++) {
            colSums[i] += a[0][i];
            for (int j = 1; j < n - 1; j++) {
                colSums[i] += a[j][i] * 2;
            }
            colSums[i] += a[n - 1][i];
        }

        int defaultSum = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1) {
                defaultSum += rowSums[i] * 2;
            } else {
                defaultSum += rowSums[i];
            }
        }

        int ans = defaultSum;

        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, Math.max(defaultSum - rowSums[i] + rowSums[0], defaultSum - rowSums[i] + rowSums[n - 1]));
        }

        for (int i = 1; i < m - 1; i++) {
            ans = Math.max(ans, Math.max(defaultSum - colSums[i] + colSums[0], defaultSum - colSums[i] + colSums[m - 1]));
        }

        System.out.print(ans);
    }
}
