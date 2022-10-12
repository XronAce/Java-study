package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_Q5656 {
    public static int N, W, H;
    public static int[][] brick, brickCopy;
    public static boolean[][] isVisited;
    public static int ans;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            ans = 0;

            brick = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    brick[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int[] innerArr : brick) {
                System.out.println(Arrays.toString(innerArr));
            }

            isVisited = new boolean[H][W];
            permutation(0, N, new int[N]);
        }
    }
    
    public static void permutation(int depth, int r, int[] out) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            brickCopy = arrayDeepCopy(brick);
            for (int i = 0; i < out.length; i++) {
                burst(out[i]);
            }
            return;
        }

        for (int i = 0; i < W; i++) {
            out[depth] = i;
            permutation(depth + 1, r, out);
        }
    }

    public static int[][] arrayDeepCopy(int[][] arr) {
        int[][] arrCopy = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                arrCopy[i][j] = arr[i][j];
            }
        }
        return arrCopy;
    }

    /*
    need to implement continuous burst of brick...
     */

    public static void burst(int hitC) {
    //     int burstRange = 0;
    //     int hitR = 0;
    //     for (int i = 0; i < H; i++) {
    //         if (brickCopy[i][hitC] != 0) {
    //             hitR = i;
    //             burstRange = brickCopy[i][hitC];
    //         }
    //     }

    //     Queue<int[]> que = new LinkedList<>();
    //     int[] temp = { hitR, hitC };
    //     que.add(temp);
    //     isVisited[hitR][hitC] = true;

    //     while (!que.isEmpty()) {
    //         int[] temp1 = que.poll();
            
    //     }
    }
    

    
}
