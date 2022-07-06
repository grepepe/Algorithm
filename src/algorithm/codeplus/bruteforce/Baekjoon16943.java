package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16943 {

    private static int b;
    private static char[] nums;
    private static boolean[] check;
    private static int tmp = 0;
    private static int ans = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        br.close();

        nums = Integer.toString(a).toCharArray();
        check = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != '0') {
                check[i] = true;
                tmp += nums[i] - '0';
                dfs(1);
                check[i] = false;
                tmp /= 10;
            }
        }

        System.out.print(ans);

    }

    private static void dfs(int cnt) {
        if (cnt == nums.length) {
            if (b > tmp) {
                ans = Math.max(ans, tmp);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    tmp *= 10;
                    tmp += nums[i] - '0';
                    dfs(cnt + 1);
                    check[i] = false;
                    tmp /= 10;
                }
            }
        }
    }
}
