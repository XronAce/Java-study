package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Baekjoon_Q11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Integer>> coordinate = new HashMap<>();

        for (int i = 0; i < N; i++) {
            List<Integer> temp = new ArrayList<>();
            if (!coordinate.containsKey(x[i]))
                coordinate.put(x[i], temp);
        }

        for (int i = 0; i < N; i++) {
            coordinate.get(x[i]).add(y[i]);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(coordinate.get(x[i]));
        }

        for (Entry<Integer, List<Integer>> e : coordinate.entrySet()) {
            for (int i = 0; i < e.getValue().size(); i++) {
                System.out.println(e.getKey() + " " + e.getValue().get(i));
            }
        }

    }
}