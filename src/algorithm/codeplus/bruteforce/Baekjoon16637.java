package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon16637 {

    private static char[] op;
    private static int[] num;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] exp = br.readLine().toCharArray();

        br.close();

        op = new char[n / 2];
        num = new int[n / 2];

        for (int i = 1; i < n; i += 2) {
            op[i / 2] = exp[i];
            num[i / 2] = exp[i + 1] - '0';
        }

        dfs(0, exp[0] - '0');

        System.out.print(ans);
    }

    private static void dfs(int i, int tmp) {
        if (i == num.length) {
            ans = Math.max(ans, tmp);
            return;
        }

        dfs(i + 1, calc(tmp, num[i], op[i]));
        if(i < num.length - 1){
            dfs(i + 2, calc(tmp, calc(num[i], num[i + 1], op[i + 1]), op[i]));
        }
    }

    private static int calc(int v1, int v2, char op) {
        switch (op) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            default:
                return 0;
        }
    }
}
