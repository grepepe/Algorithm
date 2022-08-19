package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1208 {

    private static int n, s;
    private static long ans = 0;
    private static int[] arr;
    private static final Map<Integer, Integer> cnt = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        getLeftCnt(0, 0);
        getRightCnt(n / 2, 0);

        System.out.print(s == 0 ? ans - 1 : ans);
    }

    private static void getRightCnt(int idx, int sum) {
        if (idx == n) {
            ans += cnt.getOrDefault(s - sum, 0);
        } else {
            getRightCnt(idx + 1, sum);
            getRightCnt(idx + 1, sum + arr[idx]);
        }
    }

    private static void getLeftCnt(int idx, int sum) {
        if (idx == n / 2) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        } else {
            getLeftCnt(idx + 1, sum);
            getLeftCnt(idx + 1, sum + arr[idx]);
        }
    }
}
