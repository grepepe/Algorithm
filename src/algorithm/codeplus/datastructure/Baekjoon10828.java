package algorithm.codeplus.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        intStack stk = new intStack();

        for (int cnt = 0; cnt < n; cnt++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num;

            switch(command){
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    stk.push(num);
                    break;
                case "pop":
                    sb.append(stk.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stk.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stk.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stk.top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static class intStack{

        private final ArrayList<Integer> stack;
        private int size;

        public intStack() {
            this.stack = new ArrayList<>();
            this.size = 0;
        }

        public void push(int value) {
            stack.add(value);
            size++;
        }

        public int pop() {
            if (size > 0) {

                int value = stack.get(size - 1);

                stack.remove(--size);
                return value;
            } else {
                return -1;
            }
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int top() {
            if (size == 0) {
                return -1;
            } else {
                return stack.get(size - 1);
            }
        }
    }
}
