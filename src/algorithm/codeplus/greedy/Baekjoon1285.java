package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1285 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) == 'T';
            }
        }

        int max = 1 << n;
        int ans = n * n;

        for (int bitmask = 0; bitmask < max; bitmask++) {

            int tmpTNum = 0;

            for (int i = 0; i < n; i++) {

                int tCnt = 0;

                for (int j = 0; j < n; j++) {
                    if ((bitmask & (1 << j)) != 0) {
                        if (!map[j][i]) {
                            tCnt++;
                        }
                    } else{
                        if (map[j][i]) {
                            tCnt++;
                        }
                    }
                }

                tmpTNum += Math.min(n - tCnt, tCnt);
            }

            ans = Math.min(ans, tmpTNum);
        }

        System.out.print(ans);
        br.close();
    }
}
