package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q1018 {
    static int counter(char[][] chessPlane, int startingRow, int startingColumn) {
        char firstElement = chessPlane[startingRow][startingColumn];
        int count = 0;

        for (int i=startingRow; i<startingRow+8; i++) {
            for (int j=startingColumn; j<startingColumn+8; j++) {
                if (chessPlane[i][j] != firstElement)
                    count++;
                
                    if (firstElement == 'W')
                        firstElement = 'B';
                    else
                        firstElement = 'W';
            }
            if (firstElement == 'W')
                firstElement = 'B';
            else
                firstElement = 'W';
        }      

        count = Math.min(count, 64-count);

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] input = s.split(" ");
        int r = Integer.valueOf(input[0]);
        int c = Integer.valueOf(input[1]);

        char[][] chessPlane = new char[r][c];

        for (int i=0; i<r; i++) {
            s = br.readLine();
            for (int j=0; j<c; j++) {
                chessPlane[i][j] = s.charAt(j);
            }
        }

        int min = 64;
        int result = 0;
        for (int i=0; i<=r-8; i++) {
            for (int j=0; j<=c-8; j++) {
                result = counter(chessPlane, i, j);
                min = Math.min(min, result);
            }
        }
        
        System.out.println(min);
    }
}
