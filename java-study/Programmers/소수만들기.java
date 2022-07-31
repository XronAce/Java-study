package Programmers;

public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = -1;
        /*
         * Need to implement combinations of three numbers from nums array.
         * Then call isPrimeNumber() to check.
         */

        return answer;
    }

    public static boolean isPrimeNumber(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        int sqrt = (int) Math.sqrt(sum);

        for (int i=1; i<sqrt+1; i++) {
            if (sum%i == 0)
                return false;
        }
        return true;
    }
}