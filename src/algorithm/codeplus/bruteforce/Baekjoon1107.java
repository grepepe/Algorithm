package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1107 {

    private static final boolean[] brokenButton = new boolean[10];
    private static int nLength, intN;
    private static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int m = Integer.parseInt(br.readLine());

        nLength = n.length();
        intN = Integer.parseInt(n);

        if (m > 0) {
            for (String s : br.readLine().split(" ")) {
                brokenButton[Integer.parseInt(s)] = true;
            }
        }

        if (n.equals("100")) {
            ans = 0;
        } else if (m == 0) {
            ans = Math.min(nLength, Math.abs(intN - 100));
        } else {
            ans = Math.abs(intN - 100);
            getMin("");
        }

        System.out.print(ans);
    }

    private static void getMin(String s) {
        if (nLength + 1 == s.length()) {
            ans = Math.min(ans, Math.abs(Integer.parseInt(s) - intN) + s.length());
            return;
        } else if (nLength == s.length() || (s.length() > 0 && nLength - 1 == s.length())) {
            ans = Math.min(ans, Math.abs(Integer.parseInt(s) - intN) + s.length());
        }

        for (int i = 0; i < brokenButton.length; i++) {
            if (!brokenButton[i]) {
                getMin(s + i);
            }
        }
    }
}
