package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6588 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isNotPrime = new boolean[1000001];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j < isNotPrime.length; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (true) {

            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                break;
            }

            for (int i = 3; i < number; i += 2) {
                if (!isNotPrime[i] && !isNotPrime[number - i]) {
                    sb.append(number).append(" = ").append(i).append(" + ").append(number - i).append("\n");
                    break;
                }
            }

        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
