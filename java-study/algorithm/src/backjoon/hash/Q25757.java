package backjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String playerName;
        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();

        int numPlayer;
        switch(gameType) {
            case "Y":
                numPlayer = 1;
                break;
            case "F":
                numPlayer = 2;
                break;
            default:
                numPlayer = 3;
        }

        HashSet<String> hs = new HashSet<>();
        int playerCnt = 0;
        int answer = 0;

        while (N != 0) {
            N--;
            playerName = br.readLine();
            if (!hs.contains(playerName)) {
                hs.add(playerName);
                playerCnt++;
                if (playerCnt == numPlayer) {
                    answer++;
                    playerCnt = 0;
                }
            }
        }

        System.out.println(answer);
    }
}
