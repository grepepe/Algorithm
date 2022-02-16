package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10872 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(fac(Integer.parseInt(br.readLine())));
    }

    private static int fac(int n) {
        if (n < 2) {
            return 1;
        }
        return n * fac(n - 1);
    }
}
