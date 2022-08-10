package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12908 {

    private static final long[] start = new long[2];
    private static final long[] end = new long[2];
    private static final long[][] pos = new long[4][4];
    private static final int[] order = new int[4];
    private static int bitmask = 0;
    private static long ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < start.length; i++) {
            start[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < end.length; i++) {
            end[i] = Long.parseLong(st.nextToken());
        }

        pos[0][0] = end[0];
        pos[0][1] = end[1];
        pos[0][2] = end[0];
        pos[0][3] = end[1];

        for (int i = 1; i < pos.length; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < pos[i].length; j++) {
                pos[i][j] = Long.parseLong(st.nextToken());
            }
        }

        br.close();

        makeTeleportOrder(1);

        System.out.print(ans);
    }

    private static void makeTeleportOrder(int idx) {
        if (idx == pos.length) {
//            for (int[] po : pos) {
//                for (int p : po) {
//                    System.out.print(p+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            makeOrder(0);
            return;
        }

        long[] tmp = new long[2];

        makeTeleportOrder(idx + 1);
        tmp[0] = pos[idx][0];
        tmp[1] = pos[idx][1];
        pos[idx][0] = pos[idx][2];
        pos[idx][1] = pos[idx][3];
        pos[idx][2] = tmp[0];
        pos[idx][3] = tmp[1];
        makeTeleportOrder(idx + 1);
    }

    private static void makeOrder(int idx) {
        if (idx == order.length) {
            getAnswer();
            return;
        }
        for (int i = 0; i < order.length; i++) {
            if ((bitmask & (1 << i)) == 0) {
                bitmask |= 1 << i;
                order[idx] = i;
                makeOrder(idx + 1);
                bitmask &= ~(1 << i);
            }
        }
    }

    private static void getAnswer() {

        long dis = 0;
        long[] s = new long[]{start[0], start[1]};
        long[] e = new long[2];

        for (int o : order) {
            e[0] = pos[o][0];
            e[1] = pos[o][1];
            dis += Math.abs(s[0] - e[0]) + Math.abs(s[1] - e[1]);

            if (e[0] == end[0] && e[1] == end[1]) {
                break;
            }

            dis += 10;
            s[0] = pos[o][2];
            s[1] = pos[o][3];
        }

        ans = Math.min(ans, dis);
    }

}
