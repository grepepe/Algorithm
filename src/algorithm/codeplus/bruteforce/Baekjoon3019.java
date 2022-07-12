package algorithm.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3019 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] bottom = new int[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            bottom[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int ans = 0;

        switch (p) {
            case 1:
                ans += c;
                for (int i = 3; i < c; i++) {
                    if (bottom[i - 3] == bottom[i - 2] && bottom[i - 2] == bottom[i - 1] && bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                break;
            case 2:
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                break;
            case 3:
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] == bottom[i - 1] && bottom[i - 1] + 1 == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] == bottom[i] + 1) {
                        ans++;
                    }
                }
                break;
            case 4:
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] == bottom[i - 1] + 1 && bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] + 1 == bottom[i]) {
                        ans++;
                    }
                }
                break;
            case 5:
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] == bottom[i - 1] && bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] == bottom[i - 1] + 1 && bottom[i - 1] + 1 == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] + 1 == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] == bottom[i] + 1) {
                        ans++;
                    }
                }
                break;
            case 6:
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] == bottom[i - 1] && bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] + 1 == bottom[i - 1] && bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] == bottom[i] + 2) {
                        ans++;
                    }
                }
                break;
            case 7:
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] == bottom[i - 1] && bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 2; i < c; i++) {
                    if (bottom[i - 2] == bottom[i - 1] && bottom[i - 1] == bottom[i] + 1) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] == bottom[i]) {
                        ans++;
                    }
                }
                for (int i = 1; i < c; i++) {
                    if (bottom[i - 1] + 2 == bottom[i]) {
                        ans++;
                    }
                }
                break;
        }

        System.out.print(ans);
    }
}
