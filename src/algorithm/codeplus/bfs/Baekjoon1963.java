package algorithm.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1963 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean[] isNotPrime = new boolean[10000];

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j < isNotPrime.length; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (t-- != 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = new int[4];
            int[] goal = new int[4];
            char[] input = st.nextToken().toCharArray();
            int ans = -1;

            for (int i = 0; i < start.length; i++) {
                start[i] = input[i] - '0';
            }

            input = st.nextToken().toCharArray();

            for (int i = 0; i < goal.length; i++) {
                goal[i] = input[i] - '0';
            }

            Queue<int[]> q = new LinkedList<>();
            boolean[][][][] visit = new boolean[10][10][10][10];

            visit[start[0]][start[1]][start[2]][start[3]] = true;
            q.offer(new int[]{start[0], start[1], start[2], start[3], 0});

            while (!q.isEmpty()) {

                int[] num = q.poll();

                if (num[0] == goal[0] && num[1] == goal[1] && num[2] == goal[2] && num[3] == goal[3]) {
                    ans = num[4];
                    break;
                }

                for (int i = 0; i < start.length; i++) {

                    int tmp = num[i];

                    for (int j = 0; j < 10; j++) {

                        if ((j == 0 && i == 0) || tmp == j) {
                            continue;
                        }

                        num[i] = j;

                        if (!visit[num[0]][num[1]][num[2]][num[3]]) {
                            visit[num[0]][num[1]][num[2]][num[3]] = true;
                            if (!isNotPrime[getNumber(new int[]{num[0], num[1], num[2], num[3]})]) {
                                q.offer(new int[]{num[0], num[1], num[2], num[3], num[4] + 1});
                            }
                        }
                    }

                    num[i] = tmp;
                }
            }

            sb.append(ans == -1 ? "Impossible" : ans).append('\n');
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static int getNumber(int[] num) {

        int number = 0;

        for (int n : num) {
            number *= 10;
            number += n;
        }

        return number;
    }
}
