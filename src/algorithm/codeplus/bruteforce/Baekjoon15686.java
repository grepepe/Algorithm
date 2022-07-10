package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15686 {

    private static int n, m;
    private static final List<int[]> house = new ArrayList<>();
    private static final List<int[]> chicken = new ArrayList<>();
    private static int chickenSize;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {

                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1) {
                    house.add(new int[]{i, j});
                } else if (tmp == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        chickenSize = chicken.size();

        br.close();

        dfs(0, 0, 0);

        System.out.print(ans);
    }

    private static void dfs(int start, int cnt, int bitmask) {
        if (cnt == m) {

            int sum = 0;

            for (int[] h : house) {

                int dis = n * n;

                for (int i = 0; i < chickenSize; i++) {
                    if ((bitmask & (1 << i)) != 0) {
                        dis = Math.min(dis, getDistance(h, chicken.get(i)));
                    }
                }

                sum += dis;
            }

            ans = Math.min(ans, sum);
        } else {
            for (int i = start; i < chickenSize; i++) {
                dfs(i + 1, cnt + 1, (bitmask | (1 << i)));
            }
        }
    }

    private static int getDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }

}
