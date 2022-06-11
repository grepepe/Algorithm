package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2343 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lectures = new int[n];
        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lectures[i]);
            right += lectures[i];
        }

        br.close();

        int ans = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            int tmpNum = getBlueRayNum(lectures, mid);

            if (tmpNum > m) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    private static int getBlueRayNum(int[] lectures, int size) {

        int num = 0;
        int tmp = 0;

        for (int lecture : lectures) {
            if (tmp + lecture > size) {
                num++;
                tmp = 0;
            }
            tmp += lecture;
        }

        return ++num;
    }
}
