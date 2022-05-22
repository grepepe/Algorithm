package algorithm.codeplus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon2751 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();


        StringBuilder sb = new StringBuilder();

        heapSort();

        for (int a : arr) {
            sb.append(a).append("\n");
        }

        System.out.print(sb);
    }

    private static void heapSort() {

        List<Integer> tree = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            tree.add(arr[i]);

            int childIdx = i;
            int parentIdx = (i - 1) / 2;

            while (parentIdx >= 0 && tree.get(childIdx) < tree.get(parentIdx)) {
                swapList(tree, childIdx, parentIdx);
                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        for (int i = 0; i < arr.length; i++) {

            int lastIdx = tree.size() - 1;

            arr[i] = tree.get(0);
            tree.set(0, tree.get(lastIdx));
            tree.remove(lastIdx);

            int idx = 0;
            int leftChild = 1;
            int rightChild = 2;

            while (leftChild < lastIdx) {
                if (leftChild == lastIdx - 1 || tree.get(leftChild) < tree.get(rightChild)) {
                    if (tree.get(idx) <= tree.get(leftChild)) {
                        break;
                    }
                    swapList(tree, leftChild, idx);
                    idx = leftChild;
                } else {
                    if (tree.get(idx) <= tree.get(rightChild)) {
                        break;
                    }
                    swapList(tree, rightChild, idx);
                    idx = rightChild;
                }
                leftChild = idx * 2 + 1;
                rightChild = idx * 2 + 2;
            }
        }
    }

    private static void swapList(List<Integer> list, int i, int j) {

        int tmp = list.get(i);

        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
