package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon14500 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] board = new int[n][m];
        int ans = 0;
        int[][][] tetrominos = {
                {{0, 0}, {0, 1}, {1, 1}, {1, 0}},
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
                {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
                {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
                {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
                {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
                {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
                {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
                {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
                {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
                {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
                {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
                {{0, 0}, {0, -1}, {0, -2}, {1, -2}},
                {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
                {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
                {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
                {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
                {{0, 0}, {0, -1}, {1, -1}, {2, -1}},
                {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
        };


        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int[][] tetromino : tetrominos) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    int tmpR, tmpC;
                    int total = 0;

                    for (int[] t : tetromino) {
                        tmpR = i + t[0];
                        tmpC = j + t[1];

                        if (tmpR < 0 || tmpR > n - 1 || tmpC < 0 || tmpC > m - 1) {
                            total = 0;
                            break;
                        }

                        total += board[tmpR][tmpC];
                    }

                    if (total > 0) {
                        ans = Math.max(ans, total);
                    }
                }
            }
        }

        System.out.print(ans);
    }
}
