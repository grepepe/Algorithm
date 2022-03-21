package algorithm.codeplus.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Baekjoon1339 {

    private static final int[] alphabetNum = new int[26];
    private static final Set<Character> set = new HashSet<>();
    private static char[] alphaArray;
    private static final boolean[] selected = new boolean[10];
    private static String[] words;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        words = new String[n];

        Arrays.fill(alphabetNum, -1);

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (char c : words[i].toCharArray()) {
                set.add(c);
            }
        }

        alphaArray = new char[set.size()];

        int idx = 0;

        for (char c : set) {
            alphaArray[idx++] = c;
        }

        findAns(0);

        System.out.print(ans);
    }

    private static void findAns(int idx) {
        if (idx == alphaArray.length) {

            int total = 0;

            for (String w : words) {

                int tmp = 0;

                for (char c : w.toCharArray()) {
                    tmp *= 10;
                    tmp += alphabetNum[c - 'A'];
                }

                total += tmp;
            }

            ans = Math.max(total, ans);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!selected[i]) {
                selected[i] = true;
                alphabetNum[alphaArray[idx] - 'A'] = i;
                findAns(idx + 1);
                selected[i] = false;
                alphabetNum[alphaArray[idx] - 'A'] = -1;
            }
        }
    }
}
