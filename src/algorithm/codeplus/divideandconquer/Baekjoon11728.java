package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11728 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i++]);
            } else {
                ans.add(arr2[j++]);
            }
        }

        while (i < n) {
            ans.add(arr1[i++]);
        }

        while (j < m) {
            ans.add(arr2[j++]);
        }

        StringBuilder sb = new StringBuilder();

        for (int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.print(sb);
        br.close();
    }
}
