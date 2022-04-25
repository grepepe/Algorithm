package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 1) {
                ans += 1;
            } else if (tmp > 0) {
                pos.add(tmp);
            } else {
                neg.add(tmp);
            }
        }

        pos.sort(Collections.reverseOrder());
        Collections.sort(neg);

        for (int i = 0; i < pos.size() ; i+=2) {
            ans += pos.get(i) * (pos.size() == i + 1 ? 1 : pos.get(i + 1));
        }

        for (int i = 0; i < neg.size() ; i+=2) {
            ans += neg.get(i) * (neg.size() == i + 1 ? 1 : neg.get(i + 1));
        }

        System.out.print(ans);
    }
}
