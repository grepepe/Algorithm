package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1981 {

    private static int max = 0;
    private static int min = 200;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        br.close();

        int left = 0;
        int right = max - min;
        int ans = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (canGo(n, arr, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }

    private static boolean canGo(int n, int[][] arr, int diff) {

        for (int value = min; value <= max; value++) {

            boolean[][] notVisit = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (value <= arr[i][j] && arr[i][j] <= value + diff) {
                        notVisit[i][j] = true;
                    }
                }
            }

            if (notVisit[0][0]) {
                q.offer(new int[]{0, 0});
            }

            while (!q.isEmpty()) {

                int[] pos = q.poll();

                if (pos[0] == n - 1 && pos[1] == n - 1) {
                    return true;
                }

                for (int[] d : dir) {

                    int nx = pos[0] + d[0];
                    int ny = pos[1] + d[1];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && notVisit[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        notVisit[nx][ny] = false;
                    }
                }
            }
        }
        return false;
    }
}
