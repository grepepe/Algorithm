package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] sArray = br.readLine().toCharArray();
        int[] cnt = new int['z' - 'a' + 1];
        int idx;

        Arrays.fill(cnt, -1);

        for (int i = 0; i < sArray.length; i++) {
            idx = sArray[i] - 'a';
            if (cnt[idx] == -1) {
                cnt[idx] = i;
            }
        }

        for (int c : cnt) {
            sb.append(c).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
