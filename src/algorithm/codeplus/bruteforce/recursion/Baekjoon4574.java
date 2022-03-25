package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4574 {

    private static int[][] board;
    private static boolean[][] used;
    private static boolean isFound;
    private static final StringBuilder sb = new StringBuilder();
    private static int num = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!((input = br.readLine()).equals("0"))) {

            int n = Integer.parseInt(input);
            String[] inputs;

            board = new int[10][10];
            used = new boolean[10][10];

            for (int i = 0; i < n; i++) {

                inputs = br.readLine().split(" ");
                int domino1 = Integer.parseInt(inputs[0]);
                int domino2 = Integer.parseInt(inputs[2]);

                board[inputs[1].charAt(0) - 'A' + 1][inputs[1].charAt(1) - '0'] = domino1;
                board[inputs[3].charAt(0) - 'A' + 1][inputs[3].charAt(1) - '0'] = domino2;
                if (domino1 < domino2) {
                    used[domino1][domino2] = true;
                } else {
                    used[domino2][domino1] = true;
                }
            }

            inputs = br.readLine().split(" ");

            for (int i = 0; i < 9; i++) {
                board[inputs[i].charAt(0) - 'A' + 1][inputs[i].charAt(1) - '0'] = i + 1;
            }

            isFound = false;

            dfs(0);

        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void dfs(int idx) {
        if (isFound) {
            return;
        }

        if (idx == 81) {
            isFound = true;
            sb.append("Puzzle ").append(num++).append("\n");
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        int r = idx / 9 + 1;
        int c = idx % 9 + 1;

        if (board[r][c] == 0) {
            for (int i = 1; i < 10; i++) {
                for (int j = i + 1; j < 10; j++) {
                    if (!used[i][j]) {
                        if (c < 9 && board[r][c + 1] == 0 && check(new int[][]{{r, c}, {r, c + 1}}, new int[]{i, j})) {
                            used[i][j] = true;
                            board[r][c] = i;
                            board[r][c + 1] = j;
                            dfs(idx + 1);
                            used[i][j] = false;
                            board[r][c] = 0;
                            board[r][c + 1] = 0;
                        }
                        if (c < 9 && board[r][c + 1] == 0 && check(new int[][]{{r, c}, {r, c + 1}}, new int[]{j, i})) {
                            used[i][j] = true;
                            board[r][c] = j;
                            board[r][c + 1] = i;
                            dfs(idx + 1);
                            used[i][j] = false;
                            board[r][c] = 0;
                            board[r][c + 1] = 0;
                        }
                        if (r < 9 && board[r + 1][c] == 0 && check(new int[][]{{r, c}, {r + 1, c}}, new int[]{i, j})) {
                            used[i][j] = true;
                            board[r][c] = i;
                            board[r + 1][c] = j;
                            dfs(idx + 1);
                            used[i][j] = false;
                            board[r][c] = 0;
                            board[r + 1][c] = 0;
                        }
                        if (r < 9 && board[r + 1][c] == 0 && check(new int[][]{{r, c}, {r + 1, c}}, new int[]{j, i})) {
                            used[i][j] = true;
                            board[r][c] = j;
                            board[r + 1][c] = i;
                            dfs(idx + 1);
                            used[i][j] = false;
                            board[r][c] = 0;
                            board[r + 1][c] = 0;
                        }
                    }
                }
            }
        } else {
            dfs(idx + 1);
        }
    }

    private static boolean check(int[][] ep, int[] value) {
        for (int i = 1; i < 10; i++) {
            if (board[ep[0][0]][i] == value[0]) {
                return false;
            }
            if (board[i][ep[0][1]] == value[0]) {
                return false;
            }
            if (board[ep[1][0]][i] == value[1]) {
                return false;
            }
            if (board[i][ep[1][1]] == value[1]) {
                return false;
            }
        }

        for (int i = 0; i < ep.length; i++) {

            int startR = (ep[i][0] - 1) / 3 * 3 + 1;
            int startC = (ep[i][1] - 1) / 3 * 3 + 1;

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[startR + j][startC + k] == value[i]) {
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
