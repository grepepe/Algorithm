package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16938 {

    private static int n;
    private static int l;
    private static int r;
    private static int x;
    private static int[] arr;
    private static int limit;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(arr);

        for (int i = 2; i <= n; i++) {
            limit = i;
            getAns(0, 0, new boolean[n]);
        }

        System.out.print(ans);
    }

    private static void getAns(int start, int cnt, boolean[] check) {
        if (cnt == limit) {

            int sum = 0;
            int diff = 0;

            for (int i = 0; i < n; i++) {
                if(check[i]){
                    sum += arr[i];
                    if (diff == 0) {
                        diff = arr[i];
                    }
                }
            }

            diff = arr[start-1] - diff;

            if (l <= sum && sum <= r && diff >= x) {
                ans++;
            }
        } else {
            for (int i = start; i < n; i++) {
                check[i] = true;
                getAns(i+1, cnt+1, check);
                check[i] = false;
            }
        }
    }
}
