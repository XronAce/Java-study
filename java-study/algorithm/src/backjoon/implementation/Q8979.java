package backjoon.implementation;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q8979 {
    public static class Country {
        int countryNum;
        int gold;
        int silver;
        int bronze;
        int rating;
        Country(int countryNum, int gold, int silver, int bronze, int rating) {
            this.countryNum = countryNum;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rating = rating;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Country> list = new LinkedList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int countryNum = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(countryNum, gold, silver, bronze, 0));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o2.gold == o1.gold) {
                if (o2.silver == o1.silver) {
                    return o2.bronze - o1.bronze;
                }

                return o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        });

        list.get(0).rating = 1;
        for (int i=1; i<list.size(); i++) {
            Country above = list.get(i-1);
            Country current = list.get(i);

            if (above.gold == current.gold && above.silver == current.silver && above.bronze == current.bronze) {
                current.rating = above.rating;
            } else {
                current.rating = i+1;
            }

            if (current.countryNum == K) {
                bw.write(current.rating+"\n");
                break;
            }
        }

        if (list.get(0).countryNum == K) {
            bw.write(list.get(0).rating+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
