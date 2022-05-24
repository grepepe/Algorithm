package algorithm.codeplus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11650 {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();

        heapSort();

        StringBuilder sb = new StringBuilder();

        for (int[] ar : arr) {
            for (int a : ar) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void heapSort() {

        List<int[]> tree = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);

            int child = i;
            int parent = (child - 1) / 2;

            while (parent < child && compareArr(tree.get(child), tree.get(parent)) < 0) {
                swapList(tree, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        for (int i = 0; i < arr.length; i++) {

            int lastIdx = tree.size() - 1;

            arr[i] = tree.get(0);
            tree.set(0, tree.get(lastIdx));
            tree.remove(lastIdx--);

            int parent = 0;
            int leftChild = 1;
            int rightChild = 2;
            int minChild;

            if (leftChild > lastIdx) {
                continue;
            } else if (rightChild > lastIdx) {
                minChild = leftChild;
            } else {
                minChild = compareArr(tree.get(leftChild), tree.get(rightChild)) < 0 ? leftChild : rightChild;
            }

            while (compareArr(tree.get(parent), tree.get(minChild)) > 0) {
                swapList(tree, parent, minChild);
                parent = minChild;
                leftChild = parent * 2 + 1;
                rightChild = parent * 2 + 2;

                if (leftChild > lastIdx) {
                    break;
                } else if (rightChild > lastIdx) {
                    minChild = leftChild;
                } else {
                    minChild = compareArr(tree.get(leftChild), tree.get(rightChild)) < 0 ? leftChild : rightChild;
                }
            }
        }
    }

    private static void swapList(List<int[]> list, int i, int j) {

        int[] tmp = list.get(i);

        list.set(i, list.get(j));
        list.set(j, tmp);
    }


    private static int compareArr(int[] arr1, int[] arr2) {
        if (arr1[0] == arr2[0]) {
            return Integer.compare(arr1[1], arr2[1]);
        } else {
            return Integer.compare(arr1[0], arr2[0]);
        }
    }
}
