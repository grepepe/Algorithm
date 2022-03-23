package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16197 {

    private static int n, m;
    private static char[][] board;
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int ans = 11;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int[][] coin = new int[2][2];
        int coinIdx = 0;

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'o') {
                    board[i][j] = '.';
                    coin[coinIdx][0] = i;
                    coin[coinIdx++][1] = j;
                }
            }
        }

        findAns(coin[0], coin[1], 1);

        if (ans == 11) {
            ans = -1;
        }

        System.out.print(ans);
    }

    private static void findAns(int[] coin1, int[] coin2, int cnt) {
        if (cnt <= 10) {

            int[] next1 = new int[2];
            int[] next2 = new int[2];

            for (int[] d : dir) {

                next1[0] = coin1[0] + d[0];
                next1[1] = coin1[1] + d[1];
                next2[0] = coin2[0] + d[0];
                next2[1] = coin2[1] + d[1];

                if (isIn(next1) && isIn(next2)) {
                    if (board[next1[0]][next1[1]] == '#' && board[next2[0]][next2[1]] == '.' && !(coin1[0] == next2[0] && coin1[1] == next2[1])) {
                        findAns(coin1, next2, cnt + 1);
                    } else if (board[next1[0]][next1[1]] == '.' && board[next2[0]][next2[1]] == '#' && !(coin2[0] == next1[0] && coin2[1] == next1[1])) {
                        findAns(next1, coin2, cnt + 1);
                    } else if (board[next1[0]][next1[1]] == '.' && board[next2[0]][next2[1]] == '.') {
                        findAns(next1, next2, cnt + 1);
                    }
                } else if (isIn(next1) || isIn(next2)) {
                    ans = Math.min(ans, cnt);
                }
            }
        }
    }

    private static boolean isIn(int[] pos) {
        return pos[0] > -1 && pos[0] < n && pos[1] > -1 && pos[1] < m;
    }
}
