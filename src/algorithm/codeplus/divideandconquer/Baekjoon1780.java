package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1780 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] ans = new int[3];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rule(map, ans);

        sb.append(ans[0]).append("\n").append(ans[1]).append("\n").append(ans[2]);

        System.out.print(sb);
        br.close();
    }

    private static void rule(int[][] map, int[] ans) {

        if (isAllSame(map)) {
            switch (map[0][0]) {
                case -1:
                    ans[0] ++;
                    break;
                case 0:
                    ans[1] ++;
                    break;
                case 1:
                    ans[2] ++;
                    break;
            }
        } else {

            int tmpLength = map.length / 3;
            int[][] tmpMap = new int[tmpLength][tmpLength];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < tmpLength; k++) {
                        System.arraycopy(map[tmpLength * i + k], tmpLength * j, tmpMap[k], 0, tmpLength);
                    }
                    rule(tmpMap, ans);
                }
            }
        }
    }

    private static boolean isAllSame(int[][] map) {

        int tmp = map[0][0];

        for (int[] m : map) {
            for (int e : m) {
                if (e != tmp) {
                    return false;
                }
            }
        }

        return true;
    }
}
