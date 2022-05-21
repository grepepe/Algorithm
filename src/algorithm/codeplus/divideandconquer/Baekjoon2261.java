package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2261 {

    private static List<int[]> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            arr.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        br.close();

        arr.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        System.out.print(getMinDistanceSquare(0, n - 1));
    }

    private static int getMinDistanceSquare(int left, int right) {

        int min = 800000000;

        if (right - left < 3) {
            for (int i = left; i < right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    min = Math.min(min, getDistanceSquare(arr.get(i), arr.get(j)));
                }
            }
        } else {

            int mid = (left + right) / 2;

            min = Math.min(getMinDistanceSquare(left, mid), getMinDistanceSquare(mid + 1, right));
            min = getMidDistanceSquare(min, left, right);
        }

        return min;
    }

    private static int getMidDistanceSquare(int min, int left, int right) {

        int mid = (left + right) / 2;
        List<int[]> tmp = new ArrayList<>();

        for (int i = left; i <= right; i++) {

            int dis = arr.get(i)[0] - arr.get(mid)[0];

            if (dis * dis < min) {
                tmp.add(arr.get(i));
            }
        }

        tmp.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < tmp.size() - 1; i++) {
            for (int j = i + 1; j < tmp.size(); j++) {

                int dis = tmp.get(j)[1] - tmp.get(i)[1];

                if (dis * dis >= min) {
                    break;
                }
                min = Math.min(min, getDistanceSquare(tmp.get(i), tmp.get(j)));
            }
        }

        return min;
    }

    private static int getDistanceSquare(int[] pos1, int[] pos2) {
        return (pos1[0] - pos2[0]) * (pos1[0] - pos2[0]) + (pos1[1] - pos2[1]) * (pos1[1] - pos2[1]);
    }
}
