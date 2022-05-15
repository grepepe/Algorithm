package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2447 {

    private static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (char[] m : map) {
            Arrays.fill(m, ' ');
        }

        br.close();

        getStars(0, 0, n);

        StringBuilder sb = new StringBuilder();

        for (char[] m : map) {
            for (char c : m) {
                sb.append(c);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }


    private static void getStars(int startR, int startC, int size) {

        if (size == 1) {
            map[startR][startC] = '*';
        } else {

            int num = size / 3;

            for (int i = startR; i < startR + size; i+=num) {
                for (int j = startC; j < startC + size; j+=num) {
                    if ((i / num) % 3 != 1 || (j / num) % 3 != 1) {
                        getStars(i, j, num);
                    }
                }
            }
        }

    }
}
