package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2263 {

    private static int[] inOrderIdx;
    private static int[] postOrder;
    private static final List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inOrderIdx = new int[n + 1];
        postOrder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            inOrderIdx[Integer.parseInt(st.nextToken())] = i;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(0, n - 1, 0, n - 1);

        for (int a : ans) {
            System.out.print(a+" ");
        }
        br.close();
    }

    private static void getPreOrder(int is, int ie, int ps, int pe) {

        int parent = postOrder[pe];
        int idx = inOrderIdx[parent];
        int leftSize = idx - is;
        int rightSize = ie - idx;

        ans.add(parent);

        if (leftSize > 0) {
            getPreOrder(is, idx - 1, ps, ps + leftSize - 1);
        }
        if (rightSize > 0) {
            getPreOrder(idx + 1, ie, pe - rightSize, pe - 1);
        }
    }
}
