package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class House {
    int r, c;

    public House(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Shop {
    int r, c;

    public Shop(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Baekjoon_Q15686 {
    static int N, M, shopCnt, houseCnt;
    static House[] houses;
    static Shop[] shops;
    static int[] selectedShopIdx;
    static int minCityDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] city = new int[N][N];
        shopCnt = 0;
        houseCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    houseCnt++;
                } else if (city[i][j] == 2) {
                    shopCnt++;
                }
            }
        }

        int hIdx = 0;
        int sIdx = 0;
        houses = new House[houseCnt];
        shops = new Shop[shopCnt];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) {
                    houses[hIdx++] = new House(i, j);
                } else if (city[i][j] == 2) {
                    shops[sIdx++] = new Shop(i, j);
                }
            }
        }

        selectedShopIdx = new int[M];

        if (shopCnt == M) {
            for (int i = 0; i < M; i++) {
                selectedShopIdx[i] = i;
            }
            System.out.println(cityDistance());
        } else {
            selectShop(0, 0);
            System.out.println(minCityDistance);
        }

    }

    public static void selectShop(int cnt, int start) {
        if (cnt == M) {
            minCityDistance = Math.min(minCityDistance, cityDistance());
            return;
        }

        for (int i = start; i < shopCnt; i++) {
            selectedShopIdx[cnt] = i;
            selectShop(cnt + 1, i + 1);
        }
    }

    public static int cityDistance() {
        int distance = 0;
        int shortestDist = Integer.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < houseCnt; i++) {
            House h = houses[i];
            for (int j = 0; j < M; j++) {
                Shop s = shops[selectedShopIdx[j]];
                temp = Math.abs(h.r - s.r) + Math.abs(h.c - s.c);
                shortestDist = Math.min(shortestDist, temp);
            }
            distance += shortestDist;
            shortestDist = Integer.MAX_VALUE;
        }

        return distance;
    }
}
