package algorithm.codeplus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1939 {

    private static final List<Map<Integer, Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int left = 1;
        int right = 0;

        for (int i = 0; i <= n; i++) {
            list.add(new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).put(b, c);
            list.get(b).put(a, c);
            right = Math.max(right, c);
        }

        st = new StringTokenizer(br.readLine());

        int factory1 = Integer.parseInt(st.nextToken());
        int factory2 = Integer.parseInt(st.nextToken());

        br.close();

        int ans = 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (isPossible(factory1, factory2, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    private static boolean isPossible(int start, int end, int weight) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[list.size()];

        visit[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {

            int island = q.poll();

            if (island == end) {
                return true;
            }

            for (Map.Entry<Integer, Integer> e : list.get(island).entrySet()) {

                int key = e.getKey();
                int value = e.getValue();

                if (!visit[key] && value >= weight) {
                    visit[key] = true;
                    q.offer(key);
                }
            }
        }

        return false;
    }
}
