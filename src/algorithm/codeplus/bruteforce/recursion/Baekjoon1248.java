package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1248 {

    private static int n;
    private static char[] input;
    private static boolean isFound = false;
    private static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        ans = new int[n];

        dfs(input.length, 1);

        for (int a : ans) {
            sb.append(a).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void dfs(int length, int cnt) {

        if (length == 0) {
            isFound = true;
            return;
        }

        int sign = 0;

        switch (input[length - cnt]) {
            case '+':
                sign = 1;
                break;
            case '-':
                sign = -1;
                break;
        }

        for (int i = 1; i < 11; i++) {
            if (isFound) {
                break;
            }
            ans[n - cnt] = sign * i;
            if (check(length - cnt, cnt)) {
                dfs(length - cnt, cnt + 1);
            }
        }
    }

    private static boolean check(int idx, int num) {

        int sum = ans[n - num];

        for (int i = 1; i < num; i++) {

            sum += ans[n - num + i];

            switch (input[idx + i]) {
                case '+':
                    if (sum <= 0) {
                        return false;
                    }
                    break;
                case '-':
                    if (sum >= 0) {
                        return false;
                    }
                    break;
                case '0':
                    if (sum != 0) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}
