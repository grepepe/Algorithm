package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4902 {

    private static int n;
    private static int[][] triangle;
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
            triangle = new int[n][2 * n + 1];
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

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    int col = 2 * j + 1;

                    for (int k = 0; k < col; k++) {
                        getTriangleNum(j, k, i);
                    }
                }
            }
            sb.append(tc++).append(". ").append(ans).append("\n");

        }
        br.close();

        System.out.print(sb);
    }

    private static void getTriangleNum(int r, int c, int h) {

        int num = triangle[r][c];

        if ((c & 1) == 0) {
            for (int i = 1; i <= h; i++) {
                r++;
                c++;
                if (r == n || c - i < 0 || c + i > 2 * r + 1) {
                    return;
                }

                num += sum[r][c + i];
                if (c - i > 0) {
                    num -= sum[r][c - i - 1];
                }
            }
        } else {
            for (int i = 1; i <= h; i++) {
                r--;
                c--;
                if (r == -1 || c - i < 0 || c + i > 2 * r + 1) {
                    return;
                }

                num += sum[r][c + i];
                if (c - i > 0) {
                    num -= sum[r][c - i - 1];
                }
            }
        }

        ans = Math.max(ans, num);
    }
}
