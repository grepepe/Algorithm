package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16986 {

    private static int n, k;
    private static int[][] a;
    private static final int[][] actionOrder = new int[3][20];
    private static final int[] tmp = new int[20];
    private static int bitmask = 0;
    private static boolean possible = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < actionOrder.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < actionOrder[i].length; j++) {
                actionOrder[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        if (n >= k) {
            dfs(0);
        }

        System.out.print(possible ? 1 : 0);
    }

    private static void dfs(int idx) {
        if (possible) {
            return;
        } else if (idx == n) {
            System.arraycopy(tmp, 0, actionOrder[0], 0, tmp.length);
            battle(0, 1, 2, new int[]{0, 0, 0}, new int[]{0, 0, 0});
            return;
        }

        for (int i = 1; i <= n; i++) {
            if ((bitmask & (1 << i)) == 0) {
                bitmask |= 1 << i;
                tmp[idx] = i;
                dfs(idx + 1);
                bitmask &= ~(1 << i);
            }
        }
    }

    private static void battle(int player1, int player2, int player3, int[] playerActionIdx, int[] winNum) {
        if (winNum[player1] == k) {
            if (player1 == 0) {
                possible = true;
            }
            return;
        }
        if ((player1 == 0 && playerActionIdx[player1] == n) || (player3 == 0 && playerActionIdx[player3] == n)) {
            return;
        }

        int result = a[actionOrder[player1][playerActionIdx[player1]++]][actionOrder[player2][playerActionIdx[player2]++]];

        if (result == 2 || (result == 1 && player1 > player2)) {
            winNum[player1]++;
            battle(player1, player3, player2, playerActionIdx, winNum);
        } else {
            winNum[player2]++;
            battle(player2, player3, player1, playerActionIdx, winNum);
        }
    }
}
