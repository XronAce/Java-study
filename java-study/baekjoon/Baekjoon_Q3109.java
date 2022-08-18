package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q3109 {
    public static char[][] map;
    public static int ans, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        ans = 0;
        for (int i = 0; i < R; i++) {
            if (pipeline(i, 0, 0)) {
                ans++;
            }
        }

        // for (char[] innerArr : map) {
        // System.out.println(Arrays.toString(innerArr));
        // }
        // System.out.println();
        System.out.println(ans);

    }

    public static boolean pipeline(int r, int c, int depth) {
        map[r][c] = '-';
        if (depth == C - 1) {
            return true;
        }

        if (r - 1 >= 0 && map[r - 1][c + 1] == '.') {
            if (pipeline(r - 1, c + 1, depth + 1))
                return true;
        }
        if (map[r][c + 1] == '.') {
            if (pipeline(r, c + 1, depth + 1))
                return true;
        }
        if (r + 1 < R && map[r + 1][c + 1] == '.') {
            if (pipeline(r + 1, c + 1, depth + 1))
                return true;
        }
        return false;
    }
}

/*
 * 파이프 설치 우선 순위: 오른쪽 위 대각선 > 오른쪽 > 오른쪽 아래 대각선.
 * 이렇게 해야만 최대한 많은 파이프 설치를 시도할 수 있다.
 * 1. 건물을 만나서 파이프를 설치할 수 없을 경우에 위의 우선순위 대로 설치 진행
 * 2. 한번 설치하면 설치한 곳에 -로 표기해서 건물과 같은 효과를 준다.
 */