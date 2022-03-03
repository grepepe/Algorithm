package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon15661 {

    private static int[][] arr;
    private static boolean[] team;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        team = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int a : arr[i]) {
                ans += a;
            }
        }

        for (int i = 1; i < n; i++) {
            searchAns(n, i, 0, 0);
        }

        System.out.print(ans);
    }

    private static void searchAns(int n, int selectNum, int cnt, int cur) {
        if (cnt == selectNum) {

            int start = 0, link = 0;

            for (int i = 0; i < n; i++) {
                if (team[i]) {
                    for (int j = i + 1; j < n; j++) {
                        if (team[j]) {
                            start += arr[i][j];
                            start += arr[j][i];
                        }
                    }
                } else {
                    for (int j = i + 1; j < n; j++) {
                        if (!team[j]) {
                            link += arr[i][j];
                            link += arr[j][i];
                        }
                    }
                }
            }

            ans = Math.min(ans, Math.abs(start - link));

            return;
        }
        for (int i = cur; i < n; i++) {
            team[i] = true;
            searchAns(n, selectNum, cnt + 1, i + 1);
            team[i] = false;
        }
    }
}
