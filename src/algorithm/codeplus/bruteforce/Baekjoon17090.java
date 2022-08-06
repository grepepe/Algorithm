package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17090 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][m];
        boolean[][] canExit = new boolean[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j);
            }
        }

        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!canExit[i][j]) {

                    Stack<int[]> stk = new Stack<>();
                    int r = i;
                    int c = j;

                    stk.push(new int[]{r, c});
                    visit[r][c] = true;

                    while (true) {
                        switch (maze[r][c]) {
                            case 'D':
                                r += 1;
                                break;
                            case 'U':
                                r -= 1;
                                break;
                            case 'R':
                                c += 1;
                                break;
                            case 'L':
                                c -= 1;
                                break;
                        }

                        if (r > -1 && c > -1 && r < n && c < m) {
                            if (visit[r][c]) {
                                if (canExit[r][c]) {
                                    while (!stk.isEmpty()) {
                                        int[] tmp = stk.pop();
                                        canExit[tmp[0]][tmp[1]] = true;
                                    }
                                }
                                break;
                            } else {
                                stk.push(new int[]{r, c});
                                visit[r][c] = true;
                            }
                        } else {
                            while (!stk.isEmpty()) {
                                int[] tmp = stk.pop();
                                canExit[tmp[0]][tmp[1]] = true;
                            }
                            break;
                        }
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canExit[i][j]) {
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}
