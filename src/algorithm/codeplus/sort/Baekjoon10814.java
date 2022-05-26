package algorithm.codeplus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10814 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];
        int order = 0;

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            members[i] = new Member(order++, Integer.parseInt(st.nextToken()), st.nextToken());
        }

        br.close();

        Arrays.sort(members, (o1, o2) -> {
            if (o1.age == o2.age) {
                return Integer.compare(o1.order, o2.order);
            } else {
                return Integer.compare(o1.age, o2.age);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.print(sb);
    }

    private static class Member {
        int order;
        int age;
        String name;

        public Member(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }
    }
}
