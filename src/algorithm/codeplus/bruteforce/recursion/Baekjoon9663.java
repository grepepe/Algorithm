package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9663 {

    private static int n;
    private static int[] cols;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cols = new int[n];

        finsAns(0);

        System.out.print(ans);
    }

    private static void finsAns(int row) {
        if (row == n) {
            ans++;
            return;
        }

        for (int i = 0; i < cols.length; i++) {
            if (check(row, i)) {
                cols[row] = i;
                finsAns(row+1);
            }
        }
    }

    private static boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) {
                return false;
            } else if (Math.abs(i -row) == Math.abs(cols[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
