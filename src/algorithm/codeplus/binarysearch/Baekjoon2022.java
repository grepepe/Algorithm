package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        br.close();

        double left = 0;
        double right = Math.min(x, y);

        while (Math.abs(left - right) > 0.001) {

            double mid = (left + right) / 2;

            if (getC(x, y, c, mid) < c) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.print(left);
    }

    private static double getC(double x, double y, double c, double k) {

        double xSqrt = Math.sqrt(x * x - k * k);
        double ySqrt = Math.sqrt(y * y - k * k);

        return xSqrt - (xSqrt * c / ySqrt);
    }
}
