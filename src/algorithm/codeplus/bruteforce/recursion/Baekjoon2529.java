package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2529 {

    private static boolean[] selected;
    private static final StringBuilder tmp = new StringBuilder();
    private static long max = 0L;
    private static long min = 9876543210L;
    private static StringBuilder minAns = new StringBuilder();
    private static StringBuilder maxAns = new StringBuilder();
    private static final StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] input =  br.readLine().split(" ");
        char[] signs = new char[k + 1];

        for (int i = 0; i < k; i++) {
            signs[i] = input[i].charAt(0);
        }

        selected = new boolean[10];

        for (int i = 0; i < 10; i++) {
            selected[i] = true;
            tmp.append(i);
            dfs(k, signs, 0, i, signs[0] == '<');
            selected[i] = false;
            tmp.deleteCharAt(0);
        }

        ans.append(maxAns).append("\n").append(minAns);
        System.out.print(ans);
    }

    private static void dfs(int k, char[] signs, int cnt, int pre, boolean comp) {
        if (cnt == k) {

            long total = Long.parseLong(tmp.toString());

            if (max < total) {
                max = total;
                maxAns = new StringBuilder(tmp);
            }
            if (min > total) {
                min = total;
                minAns = new StringBuilder(tmp);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!selected[i]) {
                if (comp && pre < i) {
                    selected[i] = true;
                    tmp.append(i);
                    dfs(k, signs, cnt + 1, i, signs[cnt + 1] == '<');
                    selected[i] = false;
                    tmp.deleteCharAt(tmp.length() - 1);
                } else if (!comp && pre > i) {
                    selected[i] = true;
                    tmp.append(i);
                    dfs(k, signs, cnt + 1, i, signs[cnt + 1] == '<');
                    selected[i] = false;
                    tmp.deleteCharAt(tmp.length() - 1);
                }
            }
        }
    }
}
