package algorithm.codeplus.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11723 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        String[] input;
        int bitmask = 0;

        while (m-- > 0) {
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "add":
                    bitmask |= (1 << Integer.parseInt(input[1]));
                    break;
                case "remove":
                    bitmask &= ~(1 << Integer.parseInt(input[1]));
                    break;
                case "check":
                    if ((bitmask & (1 << Integer.parseInt(input[1]))) != 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    bitmask ^= (1 << Integer.parseInt(input[1]));
                    break;
                case "all":
                    bitmask = (1 << 21) - 1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.print(sb);
    }
}
