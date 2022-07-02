package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon16937 {

    private static int h;
    private static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[][] sticker = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sticker[i][0] = Integer.parseInt(st.nextToken());
            sticker[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        List<int[]> canStick = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if ((sticker[i][0] > h && sticker[i][0] > w) || (sticker[i][1] > h && sticker[i][1] > w)) {
                continue;
            }
            canStick.add(sticker[i]);
        }

        int size = canStick.size();
        int ans = 0;

        for (int i = 0; i < size - 1; i++) {

            int[] cs1 = canStick.get(i);

            for (int j = i + 1; j < size; j++) {

                int[] cs2 = canStick.get(j);

                if (isOk(cs1, cs2)) {
                    ans = Math.max(ans, cs1[0] * cs1[1] + cs2[0] * cs2[1]);
                }
            }
        }

        System.out.print(ans);
    }

    private static boolean isOk(int[] cs1, int[] cs2) {
        return (cs1[0] + cs2[0] <= w && Math.max(cs1[1], cs2[1]) <= h)
                || (cs1[0] + cs2[0] <= h && Math.max(cs1[1], cs2[1]) <= w)
                || (cs1[1] + cs2[1] <= w && Math.max(cs1[0], cs2[0]) <= h)
                || (cs1[1] + cs2[1] <= h && Math.max(cs1[0], cs2[0]) <= w)
                || (cs1[1] + cs2[0] <= w && Math.max(cs1[0], cs2[1]) <= h)
                || (cs1[1] + cs2[0] <= h && Math.max(cs1[0], cs2[1]) <= w)
                || (cs1[0] + cs2[1] <= w && Math.max(cs1[1], cs2[0]) <= h)
                || (cs1[0] + cs2[1] <= h && Math.max(cs1[1], cs2[0]) <= w);
    }
}
