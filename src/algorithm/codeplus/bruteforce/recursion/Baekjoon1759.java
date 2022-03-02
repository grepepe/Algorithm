package algorithm.codeplus.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1759 {

    private static final StringBuilder sb = new StringBuilder();
    private static char[] tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Character[] arr = Arrays.stream(br.readLine().split(" ")).map(str -> str.charAt(0)).toArray(Character[]::new);
        tmp = new char[input[0]];

        Arrays.sort(arr);

        searchAns(input[0], input[1], arr, 0, 0, 0, 0);

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void searchAns(int l, int c, Character[] arr, int cnt, int cur, int con, int vow) {
        if (cnt == l) {
            if (con > 1 && vow > 0) {
                for (char t : tmp) {
                    sb.append(t);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = cur; i < c; i++) {
            tmp[cnt] = arr[i];
            searchAns(l, c, arr, cnt + 1, i + 1, !isVowel(arr[i]) ? con + 1 : con, isVowel(arr[i]) ? vow + 1 : vow);
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
