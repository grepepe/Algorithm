package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon1655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (left.size() > right.size()) {
                if (arr[i] < left.peek()) {
                    right.offer(left.poll());
                    left.offer(arr[i]);
                } else {
                    right.offer(arr[i]);
                }
            } else {
                if (!right.isEmpty() && arr[i] > right.peek()) {
                    left.offer(right.poll());
                    right.offer(arr[i]);
                } else {
                    left.offer(arr[i]);
                }
            }
            sb.append(left.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
