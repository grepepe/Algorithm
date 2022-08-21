package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon2143 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Map<Long, Long> cnt = new HashMap<>();

        for (int size = 1; size <= n; size++) {
            for (int start = 0; start <= n - size; start++) {

                long sum = 0;

                for (int i = start; i < start + size; i++) {
                    sum += a[i];
                }
                cnt.put(sum, cnt.getOrDefault(sum, 0L) + 1);
            }
        }

        long ans = 0;

        for (int size = 1; size <= m; size++) {
            for (int start = 0; start <= m - size; start++) {

                long sum = 0;

                for (int i = start; i < start + size; i++) {
                    sum += b[i];
                }
                ans += cnt.getOrDefault(t - sum, 0L);
            }
        }

        System.out.print(ans);
    }
}
