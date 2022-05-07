package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();

        for (int t : targets) {

            int ans = 0;
            int left = 0;
            int right = n - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                if (cards[mid] > t) {
                    right = mid - 1;
                } else if (cards[mid] < t) {
                    left = mid + 1;
                } else {
                    ans = 1;
                    break;
                }
                mid = (left + right) / 2;
            }

            sb.append(ans).append(" ");
        }

        System.out.print(sb);
    }
}
