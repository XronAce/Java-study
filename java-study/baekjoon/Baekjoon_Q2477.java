package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q2477 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int bigRecHeight = 0;
        int bigRecWidth = 0;
        int smallRecHeight = 0;
        int smallRecWidth = 0;
        int[] height = new int[3];
        int[] width = new int[3];
        int[] sides = new int[6];
        int heightIdx = 0;
        int maxHeightIdx = 0;
        int widthIdx = 0;
        int maxWidthIdx = 0;
        int direction = 0;
        int length = 0;
        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            direction = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            sides[i] = length;
            if (direction == 3 || direction == 4) {
                height[heightIdx++] = length;
            } else {
                width[widthIdx++] = length;
            }
        }
        for (int i = 0; i < 3; i++) {
            bigRecHeight = Math.max(bigRecHeight, height[i]);
            bigRecWidth = Math.max(bigRecWidth, width[i]);
        }

        for (int i = 0; i < 6; i++) {
            if (sides[i] == bigRecHeight) {
                maxHeightIdx = i;
            }
            if (sides[i] == bigRecWidth) {
                maxWidthIdx = i;
            }
        }

        if (maxHeightIdx == 0) {
            smallRecWidth = Math.abs(sides[5] - sides[1]);
        } else if (maxHeightIdx == 5) {
            smallRecWidth = Math.abs(sides[4] - sides[0]);
        } else {
            smallRecWidth = Math.abs(sides[maxHeightIdx + 1] - sides[maxHeightIdx - 1]);
        }

        if (maxWidthIdx == 0) {
            smallRecHeight = Math.abs(sides[5] - sides[1]);
        } else if (maxWidthIdx == 5) {
            smallRecHeight = Math.abs(sides[4] - sides[0]);
        } else {
            smallRecHeight = Math.abs(sides[maxWidthIdx + 1] - sides[maxWidthIdx - 1]);
        }

        int area = (bigRecHeight * bigRecWidth) - (smallRecHeight * smallRecWidth);
        area *= K;
        System.out.println(area);
    }
}
