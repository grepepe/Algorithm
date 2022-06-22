package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1561 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] rides = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            rides[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int ans = n;

        if (n > m) {

            long left = 0L;
            long right = 60000000000L;
            long time = 0;
            long tmpPersonNum;

            while (left <= right) {

                long mid = (left + right) / 2;

                tmpPersonNum = m;

                for (int r : rides) {
                    tmpPersonNum += mid / r;
                }

                if (tmpPersonNum < n) {
                    left = mid + 1;
                } else {
                    time = mid;
                    right = mid - 1;
                }
            }

            tmpPersonNum = m;

            for (int r : rides) {
                tmpPersonNum += (time - 1) / r;
            }


            for (int i = 0; i < m; i++) {
                if (time % rides[i] == 0) {
                    if (++tmpPersonNum == n) {
                        ans = i + 1;
                        break;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}
