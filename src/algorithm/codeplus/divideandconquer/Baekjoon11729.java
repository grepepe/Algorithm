package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon11729 {

    private static int num = 0;
    private static final List<int[]> process = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        move(1, 2, 3, n);

        ans.append(num).append("\n");
        for (int[] p : process) {
            ans.append(p[0]).append(" ").append(p[1]).append("\n");
        }
        ans.deleteCharAt(ans.length() - 1);
        System.out.print(ans);
        br.close();
    }

    private static void move(int start, int tmp, int dest, int n) {
        if (n == 1) {
            process.add(new int[]{start, dest});
        } else {
            move(start, dest, tmp, n - 1);
            process.add(new int[]{start, dest});
            move(tmp, start, dest, n - 1);
        }
        num++;
    }
}
