package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String num = st.nextToken();
        int[] nums = new int[d];
        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        br.close();

        long mapLength = 1;
        long c = 0;
        long r = 0;

        for (int i = 0; i < d; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        for (int i = 0; i < d; i++) {
            mapLength *= 2;
            c *= 2;
            r *= 2;
            if (nums[i] == 1) {
                c += 1;
                r += 1;
            } else if (nums[i] == 2) {
                r += 1;
            } else if (nums[i] == 4) {
                c += 1;
            }
        }

        c += x;
        r += y;

        StringBuilder sb = new StringBuilder();

        if (r > -1 && r < mapLength && c > -1 && c < mapLength) {

            long halfLength = mapLength / 2;

            while (halfLength != 0) {
                if (c >= halfLength) {
                    if (r >= halfLength) {
                        sb.append(1);
                    } else {
                        sb.append(4);
                    }
                } else {
                    if (r >= halfLength) {
                        sb.append(2);
                    } else {
                        sb.append(3);
                    }
                }
                c %= halfLength;
                r %= halfLength;
                halfLength /= 2;
            }
        } else {
            sb.append(-1);
        }

        System.out.print(sb);
    }
}
