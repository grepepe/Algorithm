package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3085 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        String s;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                ans = Math.max(ans, getMaxCandy(changeBoard(board, i, j, true)));
                ans = Math.max(ans, getMaxCandy(changeBoard(board, i, j, false)));
            }
        }

        System.out.print(ans);
    }

    private static char[][] changeBoard(char[][] board, int r, int c, boolean dir) {

        char[][] changedBoard = new char[board.length][board[0].length];
        char tmp;

        for (int i=0; i<board.length; i++) {
            System.arraycopy(board[i], 0, changedBoard[i], 0, board[0].length);
        }

        if (dir) {
            tmp = changedBoard[r][c];
            changedBoard[r][c] = changedBoard[r][c + 1];
            changedBoard[r][c + 1] = tmp;
        } else {
            tmp = changedBoard[c][r];
            changedBoard[c][r] = changedBoard[c + 1][r];
            changedBoard[c + 1][r] = tmp;
        }

        return changedBoard;
    }

    private static int getMaxCandy(char[][] board) {

        int max = 0, rLength, cLength;
        char rTmp, cTmp;

        for (int i = 0; i < board.length; i++) {
            rTmp = board[0][i];
            cTmp = board[i][0];
            rLength = 1;
            cLength = 1;

            for (int j = 1; j < board.length; j++) {

                if (rTmp != board[j][i]) {
                    max = Math.max(max, rLength);
                    rTmp = board[j][i];
                    rLength = 1;
                } else {
                    rLength++;
                }

                if (cTmp != board[i][j]) {
                    max = Math.max(max, cLength);
                    cTmp = board[i][j];
                    cLength = 1;
                } else {
                    cLength++;
                }
            }

            max = Math.max(max, rLength);
            max = Math.max(max, cLength);
        }

        return max;
    }
}
