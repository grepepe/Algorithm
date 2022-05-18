package algorithm.codeplus.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1933 {

    private static final List<int[]> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        br.close();

        arr.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[2], o2[2]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        List<int[]> ans = getAns(0, n - 1);
        StringBuilder sb = new StringBuilder();

        for (int[] a : ans) {
            sb.append(a[0]).append(" ").append(a[1]).append(" ");
        }

        System.out.print(sb);
    }

    private static List<int[]> getAns(int start, int end) {
        if (start == end) {
            return new ArrayList<>() {{
                add(new int[]{arr.get(start)[0], arr.get(start)[1]});
                add(new int[]{arr.get(start)[2], 0});
            }};
        } else {

            int mid = (start + end) / 2;

            List<int[]> left = getAns(start, mid);
            List<int[]> right = getAns(mid + 1, end);
            return merge(left, right);
        }

    }

    private static List<int[]> merge(List<int[]> left, List<int[]> right) {

        List<int[]> mergedArr = new ArrayList<>();
        int mSize = 0;
        int lSize = left.size();
        int rSize = right.size();
        int i = 0;
        int j = 0;
        int leftLastHeight = 0;
        int rightLastHeight = 0;

        while (i < lSize && j < rSize) {
            if (left.get(i)[0] < right.get(j)[0]) {

                leftLastHeight = left.get(i)[1];

                if (mergedArr.isEmpty()) {
                    mergedArr.add(left.get(i));
                    mSize++;
                } else {

                    int height = Math.max(rightLastHeight, leftLastHeight);

                    if (mergedArr.get(mSize - 1)[0] == left.get(i)[0]) {
                        mergedArr.set(mSize - 1, new int[]{left.get(i)[0], height});
                    } else if (mergedArr.get(mSize - 1)[1] != height) {
                        mergedArr.add(new int[]{left.get(i)[0], height});
                        mSize++;
                    }
                }
                i++;
            } else {

                rightLastHeight = right.get(j)[1];

                if (mergedArr.isEmpty()) {
                    mergedArr.add(right.get(j));
                    mSize++;
                } else {

                    int height = Math.max(rightLastHeight, leftLastHeight);

                    if (mergedArr.get(mSize - 1)[0] == right.get(j)[0]) {
                        mergedArr.set(mSize - 1, new int[]{right.get(j)[0], height});
                    } else if (mergedArr.get(mSize - 1)[1] != height) {
                        mergedArr.add(new int[]{right.get(j)[0], height});
                        mSize++;
                    }
                }
                j++;
            }
        }

        while (i < lSize) {
            if (mergedArr.isEmpty()) {
                mergedArr.add(left.get(i));
                mSize++;
            } else {
                if (mergedArr.get(mSize - 1)[0] == left.get(i)[0]) {
                    mergedArr.set(mSize - 1, left.get(i));
                } else {
                    mergedArr.add(left.get(i));
                    mSize++;
                }
            }
            i++;
        }

        while (j < rSize) {
            if (mergedArr.isEmpty()) {
                mergedArr.add(right.get(j));
                mSize++;
            } else {
                if (mergedArr.get(mSize - 1)[0] == right.get(j)[0]) {
                    mergedArr.set(mSize - 1, right.get(j));
                } else {
                    mergedArr.add(right.get(j));
                    mSize++;
                }
            }
            j++;
        }

        return mergedArr;
    }
}