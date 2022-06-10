package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11664 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] a = new double[3];
        double[] b = new double[3];
        double[] c = new double[3];

        for (int i = 0; i < 3; i++) {
            a[i] = Double.parseDouble(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            b[i] = Double.parseDouble(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            c[i] = Double.parseDouble(st.nextToken());
        }

        br.close();

        double[] left = new double[3];
        double[] right = new double[3];

        System.arraycopy(a, 0, left, 0, 3);
        System.arraycopy(b, 0, right, 0, 3);

        double[] mid1 = new double[3];
        double[] mid2 = new double[3];

        while (Math.abs(getlength(left, right)) > 0.0000001) {
            for (int i = 0; i < 3; i++) {
                mid1[i] = (2 * left[i] + right[i]) / 3;
            }
            for (int i = 0; i < 3; i++) {
                mid2[i] = (left[i] + 2 * right[i]) / 3;
            }

            if (getlength(c, mid1) < getlength(c, mid2)) {
                System.arraycopy(mid2, 0, right, 0, 3);
            } else {
                System.arraycopy(mid1, 0, left, 0, 3);
            }
        }

        System.out.print(getlength(c, left));
    }

    private static double getlength(double[] point1, double[] point2) {
        return Math.sqrt((point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]) + (point1[2] - point2[2]) * (point1[2] - point2[2]));
    }
}
