package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2580 {

    private static final int[][] board = new int[9][9];
    private static final List<int[]> zero = new ArrayList<>();
    private static boolean isFound = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }

        dfs(0);

    }

    private static void dfs(int idx) {
        if (idx == zero.size()) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }

            sb.deleteCharAt(sb.length() - 1);
            System.out.print(sb);

            isFound = true;
            return;
        }

        int[] tmp = zero.get(idx);

        for (int i = 1; i < 10; i++) {
            if (isFound) {
                break;
            }
            if (check(tmp[0], tmp[1], i)) {
                board[tmp[0]][tmp[1]] = i;
                dfs(idx + 1);
                board[tmp[0]][tmp[1]] = 0;
            }
        }
    }

    private static boolean check(int r, int c, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == value) {
                return false;
            } else if (board[r][i] == value) {
                return false;
            }
        }

        int startR = r / 3 * 3;
        int startC = c / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startR + i][startC + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
