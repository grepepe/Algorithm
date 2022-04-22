package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon12015 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for (int a : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) < a) {
                list.add(a);
            } else {

                int left = 0;
                int right = list.size();
                int mid;

                do {
                    mid = (left + right) / 2;

                    if (list.get(mid) < a) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                } while (left != mid);

                list.set(right, a);
            }
        }

        System.out.print(list.size());
    }
}
