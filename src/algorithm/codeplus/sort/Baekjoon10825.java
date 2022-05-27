package algorithm.codeplus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10825 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Score[] scores = new Score[n];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            scores[i] = new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        br.close();

        Arrays.sort(scores, (o1, o2) -> {
            if (o1.korean == o2.korean) {
                if (o1.english == o2.english) {
                    if (o1.math == o2.math) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        return Integer.compare(o2.math, o1.math);
                    }
                } else {
                    return Integer.compare(o1.english, o2.english);
                }
            } else {
                return Integer.compare(o2.korean, o1.korean);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Score s : scores) {
            sb.append(s.name).append("\n");
        }

        System.out.print(sb);
    }

    private static class Score {
        String name;
        int korean;
        int english;
        int math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
