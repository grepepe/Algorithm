package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1080 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][m];
        boolean[][] map = new boolean[n][m];
        boolean impossible = false;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) == '1';
            }
        }

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = (input.charAt(j) == '1') ^ arr[i][j];
            }
        }

        if (n > 2 && m > 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j]) {
                        if (i < n - 2 && j < m - 2) {
                            for (int k = 0; k < 3; k++) {
                                for (int l = 0; l < 3; l++) {
                                    map[i + l][j + k] = !map[i + l][j + k];
                                }
                            }
                            ans++;
                        } else {
                            impossible = true;
                            ans = -1;
                        }
                    }
                }
                if (impossible) {
                    break;
                }
            }

        } else {
            for (boolean[] maps : map) {
                for (boolean ma : maps) {
                    if (ma) {
                        impossible = true;
                        ans = -1;
                        break;
                    }
                }
                if (impossible) {
                    break;
                }
            }
        }

        System.out.print(ans);
    }
}
