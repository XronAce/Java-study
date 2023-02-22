package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> onBridge = new LinkedList<>();
        Queue<Integer> truckLeft = new LinkedList<>();
        int time = 0;
        int numTruckPassed = 0;
        int bridgeWeight = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            truckLeft.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<w; i++) {
            onBridge.offer(0);
        }

        while (numTruckPassed != n) {
            time++;
//            Iterator iter = onBridge.iterator();
//            while (iter.hasNext()) {
//                System.out.print(iter.next() + " ");
//            }
//            System.out.println();
            if (onBridge.peek() != null) {
                if (onBridge.peek() != 0) {
                    numTruckPassed++;
                }
                bridgeWeight -= onBridge.poll();
            }

            if (truckLeft.peek() != null) {
                if ((L - bridgeWeight) >= truckLeft.peek()) {
                    int truck = truckLeft.poll();
                    onBridge.offer(truck);
                    bridgeWeight += truck;
                } else {
                    onBridge.offer(0);
                }
            }
        }

        System.out.println(time);

    }
}
