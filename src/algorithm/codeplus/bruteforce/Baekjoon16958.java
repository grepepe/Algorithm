package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16958 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] info = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[][] pairs = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                pairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        int[][] dis = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = Math.abs(info[i][1] - info[j][1]) + Math.abs(info[i][2] - info[j][2]);
                    if (info[i][0] == 1 && info[j][0] == 1) {
                        dis[i][j] = Math.min(dis[i][j], t);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] p : pairs) {
            sb.append(dis[p[0]][p[1]]).append("\n");
        }

        System.out.print(sb);
    }
}
