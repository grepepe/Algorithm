package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon10866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        intDeque deque = new intDeque();

        while (n-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.popFront()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.popBack()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static class intDeque {

        private final LinkedList<Integer> deque;
        private int size;

        public intDeque() {
            deque = new LinkedList<>();
            size = 0;
        }

        public void pushFront(int x) {
            deque.offerFirst(x);
            size++;
        }

        public void pushBack(int x) {
            deque.offer(x);
            size++;
        }

        public int popFront() {
            if (size == 0) {
                return -1;
            }
            int value = deque.get(0);

            deque.remove(0);
            size--;

            return value;
        }

        public int popBack() {
            if (size == 0) {
                return -1;
            }
            int value = deque.get(size - 1);

            deque.remove(size - 1);
            size--;

            return value;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return deque.get(0);
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return deque.get(size - 1);
        }
    }
}
