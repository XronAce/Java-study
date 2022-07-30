package programmers;

class Solution내적 {
    public int solution(int[] a, int[] b) {
        int dotProduct = 0;
        for (int i=0; i<a.length; i++) {
            dotProduct += a[i]*b[i];
        }

        return dotProduct;
    }

    // public static void main(String[] args) {
    //     int[] a = new int[] {1,2,3,4};
    //     int[] b = new int[] {-3,-1,0,2};
    //     System.out.println(solution(a, b));
    // }
}

