package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2303 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cards = new int[n + 1][5];
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int maxNum = 0;

        for (int i = 1; i <= n; i++) {

            int tmp = getMaxNum(0, 0, 0, new boolean[5], cards[i]);

            if (maxNum <= tmp) {
                ans = i;
                maxNum = tmp;
            }
        }

        System.out.print(ans);
    }

    private static int getMaxNum(int selectNum, int next, int max, boolean[] select, int[] card) {
        if (selectNum == 3) {

            int tmp = 0;

            for (int i = 0; i < 5; i++) {
                if (select[i]) {
                    tmp += card[i];
                }
            }

            return tmp % 10;
        } else {
            for (int i = next; i < 5; i++) {
                select[i] = true;
                max = Math.max(max, getMaxNum(selectNum + 1, i + 1, max, select, card));
                select[i] = false;
            }

            return max;
        }

    }
}
