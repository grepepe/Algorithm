package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1201 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder ans = new StringBuilder("-1");

        if (m + k - 1 <= n && m * k >= n) { // m+k-1: 한 숫자만 공유하는 경우, n*k: 감소,감소,감소,...,감소 -> 감소 부분 순열 전체가 증가 부분 순열이 되도록

            int[] arr = new int[n];
            int idx = 0;

            // m개의 감소 부분 순열 그룹 만들기 (그룹 자체는 증가 부분 순열이 되도록)
            // 감소 순열 k만큼 처음에 만듬
            // 나머지 m-1 개의 그룹은 조건에 맞도록 구현
            for (int i = 0; i < k; i++) {
                arr[idx] = k - idx;
                idx++;
            }

            n -= k;
            m--;

            if (m != 0) {
                int quotient = n / m;
                int remainder = n % m;

                for (int i = 0; i < m; i++) {

                    int start = idx;
                    int num = quotient;

                    if (remainder > 0) {
                        num++;
                        remainder--;
                    }

                    for (int j = 0; j < num; j++) {
                        arr[idx++] = num + start - j;
                    }
                }
            }

            ans = new StringBuilder();

            for (int a : arr) {
                ans.append(a).append(" ");
            }
            ans.deleteCharAt(ans.length() - 1);
        }

        System.out.print(ans);
    }
}
