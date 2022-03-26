package algorithm.codeplus.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13460 {

    private static int n, m;
    private static boolean[][] map;
    private static boolean[][][][] visit;
    private static final int[] goal = new int[2];
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int ans = 11;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visit = new boolean[n][m][n][m];
        int[] red = new int[2];
        int[] blue = new int[2];

        for (int i = 0; i < n; i++) {

            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                switch (input[j]) {
                    case 'R':
                        red[0] = i;
                        red[1] = j;
                        break;
                    case 'B':
                        blue[0] = i;
                        blue[1] = j;
                        break;
                    case 'O':
                        goal[0] = i;
                        goal[1] = j;
                        break;
                    case '#':
                        map[i][j] = true;
                        break;
                }
            }
        }

        visit[red[0]][red[1]][blue[0]][blue[1]] = true;
        dfs(0, red, blue);

        if (ans == 11) {
            ans = -1;
        }

        System.out.print(ans);
    }

    private static void dfs(int cnt, int[] red, int[] blue) {
        if (cnt < 11) {
            if (goal[0] == red[0] && goal[1] == red[1]) {
                ans = Math.min(ans, cnt);
                return;
            }

            for (int[] d : dir) {

                int[] newRed = move(red, d);
                int[] newBlue = move(blue, d);

                if (newRed[0] == newBlue[0] && newRed[1] == newBlue[1]) {
                    if (newRed[0] == goal[0] && newRed[1] == goal[1]) {
                        continue;
                    }
                    if (d[0] == 0) {
                        if ((red[1] - blue[1]) * d[1] < 0) {
                            newRed[1] -= d[1];
                        } else {
                            newBlue[1] -= d[1];
                        }
                    } else {
                        if ((red[0] - blue[0]) * d[0] < 0) {
                            newRed[0] -= d[0];
                        } else {
                            newBlue[0] -= d[0];
                        }
                    }
                }

                if (!visit[newRed[0]][newRed[1]][newBlue[0]][newBlue[1]]) {
                    visit[newRed[0]][newRed[1]][newBlue[0]][newBlue[1]] = true;
                    dfs(cnt + 1, newRed, newBlue);
                    visit[newRed[0]][newRed[1]][newBlue[0]][newBlue[1]] = false;
                }
            }
        }
    }

    private static int[] move(int[] ball, int[] d) {

        int[] newBall = new int[2];

        newBall[0] = ball[0];
        newBall[1] = ball[1];

        do {
            if (newBall[0] == goal[0] && newBall[1] == goal[1]) {
                return newBall;
            }
            newBall[0] += d[0];
            newBall[1] += d[1];
        } while (check(newBall[0], newBall[1]));

        newBall[0] -= d[0];
        newBall[1] -= d[1];

        return newBall;
    }

    private static boolean check(int r, int c) {
        return r > -1 && c > -1 && r < n && c < m && !map[r][c];
    }
}
