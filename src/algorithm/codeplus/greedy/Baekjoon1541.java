package algorithm.codeplus.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
        Queue<Integer> operand = new LinkedList<>();

        while (minus.hasMoreTokens()) {

            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
            int tmp = 0;

            while (plus.hasMoreTokens()) {
                tmp += Integer.parseInt(plus.nextToken());
            }

            operand.offer(tmp);
        }
        int ans = 0;

        if (!operand.isEmpty()) {
            ans  = operand.poll();
        }

        while (!operand.isEmpty()) {
            ans -= operand.poll();
        }

        System.out.print(ans);
    }
}
