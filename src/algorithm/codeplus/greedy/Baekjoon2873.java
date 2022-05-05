package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2873 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if ((r & 1) != 0) {
            getPath1(ans, r, c, "R", "L", "D");
            ans.deleteCharAt(ans.length() - 1);
        } else if ((c & 1) != 0) {
            getPath1(ans, c, r, "D", "U", "R");
            ans.deleteCharAt(ans.length() - 1);
        } else {

            int[] minPos = new int[2];
            int min = 1001;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (((i + j) & 1) != 0 && min > map[i][j]) {
                        minPos[0] = i;
                        minPos[1] = j;
                        min = map[i][j];
                    }
                }
            }

            int tmpR = (minPos[0] & 1) == 0 ? minPos[0] : minPos[0] - 1;
            int tmpC = minPos[1];

            getPath1(ans, tmpR, c, "R", "L", "D");
            getPath1(ans, tmpC, 2,"D", "U", "R");

            if ((tmpC & 1) == 0){
                getPath2(ans, c - tmpC - 1, 2, "D", "U", "R");
            } else {
                getPath2(ans, c - tmpC - 1, 2, "U", "D", "R");
            }

            if (tmpR < r - 1) {
                if ((tmpR & 1) == 0) {
                    getPath2(ans, r - tmpR - 2, c, "L", "R", "D");
                } else {
                    getPath2(ans, r - tmpR - 1, c, "L", "R", "D");
                }
            }
        }

        System.out.print(ans);
    }

    private static void getPath2(StringBuilder path, int num1, int num2, String dir1, String dir2, String nextDir) {
        for (int i = 0; i < num1; i++) {
            path.append(nextDir);
            if ((i & 1) == 0) {
                path.append(dir1.repeat(num2 - 1));
            } else {
                path.append(dir2.repeat(num2 - 1));
            }
        }
    }

    private static void getPath1(StringBuilder path, int num1, int num2, String dir1, String dir2, String nextDir) {
        for (int i = 0; i < num1; i++) {
            if ((i & 1) == 0) {
                path.append(dir1.repeat(num2 - 1));
            } else {
                path.append(dir2.repeat(num2 - 1));
            }
            path.append(nextDir);
        }
    }
}
