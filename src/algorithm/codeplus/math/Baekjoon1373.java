package algorithm.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1373 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder bNum = new StringBuilder(br.readLine());
        int remainder = bNum.length() % 3;

        if (remainder != 0) {
            while (remainder++ != 3) {
                bNum.insert(0, "0");
            }
        }

        char[] addedBNum = bNum.toString().toCharArray();

        for (int i = 0; i < addedBNum.length; i += 3) {
            sb.append((addedBNum[i] - '0') * 4 + (addedBNum[i + 1] - '0') * 2 + addedBNum[i + 2] - '0');
        }

        System.out.print(sb);
    }
}
