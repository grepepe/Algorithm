package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16945 {

    private static final int[] square = new int[9];
    private static final int[] tmp = new int[9];
    private static int bitmask = 0;
    private static int ans = 81;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                square[3 * i + j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        sol(0);

        System.out.print(ans);
    }

    private static void sol(int idx) {
        if (idx == 9) {
            if (isMagicSquare()) {
                ans = Math.min(ans, getCost());
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if ((bitmask & (1 << i)) == 0) {
                bitmask |= 1 << i;
                tmp[idx] = i;
                sol(idx+1);
                bitmask &= ~(1 << i);
            }
        }
    }

    private static boolean isMagicSquare() {

        int sum = tmp[0] + tmp[1] + tmp[2];

        return tmp[3]+tmp[4]+tmp[5] == sum && tmp[6]+tmp[7]+tmp[8] == sum && tmp[0]+tmp[3]+tmp[6] == sum && tmp[1]+tmp[4]+tmp[7] == sum && tmp[2]+tmp[5]+tmp[8] == sum  && tmp[0]+tmp[4]+tmp[8] == sum && tmp[2]+tmp[4]+tmp[6] == sum;
    }

    private static int getCost() {

        int cost = 0;

        for (int i = 0; i < square.length; i++) {
            cost += Math.abs(square[i] - tmp[i]);
        }
        return cost;
    }
}
