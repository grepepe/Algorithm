package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon10845 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        intQueue queue = new intQueue();

        while (n-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.push(x);
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static class intQueue {

        private final LinkedList<Integer> queue;
        private int size;

        public intQueue() {
            this.queue = new LinkedList<>();
            this.size = 0;
        }

        public void push(int x) {
            queue.offer(x);
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }

            int value = queue.get(0);

            queue.remove(0);
            size--;

            return value;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size > 0 ? 0 : 1;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return queue.get(0);
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return queue.get(size - 1);
        }
    }
}
