package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4902 {

    private static int n;
    private static int[][] sum;
    private static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        int tc = 1;

        while (!(input = br.readLine()).equals("0")) {

            StringTokenizer st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            int[][] triangle = new int[n][2 * n + 1];
            sum = new int[n][2 * n + 1];

            for (int i = 0; i < n; i++) {

                int col = 2 * i + 1;

                for (int j = 0; j < col; j++) {
                    triangle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {

                int col = 2 * i + 1;

                sum[i][0] = triangle[i][0];

                for (int j = 1; j < col; j++) {
                    sum[i][j] = triangle[i][j] + sum[i][j - 1];
                }
            }

            ans = -3000;

            for (int row = 0; row < n; row++) {

                int maxCol = 2 * row + 1;

                for (int col = 0; col < maxCol; col++) {
                    getTriangleNum(row, col);
                }
            }

            sb.append(tc++).append(". ").append(ans).append("\n");

        }
        br.close();

        System.out.print(sb);
    }

    private static void getTriangleNum(int r, int c) {

        int tmpSum = 0;

        if ((c & 1) == 0) {
            for (int size = 0; size < n; size++) {
                if (r + size >= n) {
                    break;
                }
                tmpSum += sum[r + size][c + 2 * size];
                if (c > 0) {
                    tmpSum -= sum[r + size][c - 1];
                }
                ans = Math.max(ans, tmpSum);
            }
        } else {
            for (int size = 0; size < n; size++) {
                if (r - size < 0 || 2 * (r - size) < c || c < 2 * size) {
                    break;
                }
                tmpSum += sum[r - size][c];
                if (c > 2 * size) {
                    tmpSum -= sum[r - size][c - 2 * size - 1];
                }
                ans = Math.max(ans, tmpSum);
            }
        }
    }
}
