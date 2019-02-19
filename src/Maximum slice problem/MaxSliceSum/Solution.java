import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {

//		int[] A = {3,2,-6,4,0};
//		testIt(A);
//		int[] B = {1,2,3,4,5,6,7,8,9,10};
//		testIt(B);
        int[] C = {-2, -2, 1};
        testIt(C);
        int[] D = randomIntArray(10);
        testIt(D);
//		int[] E = IntStream.iterate(randomInt(), a -> randomInt()).limit(10).toArray();
//		testIt(E);
//		int[] F = IntStream.iterate(randomInt(), a -> randomInt()).limit(10).toArray();
//		testIt(F);
    }

    private static int[] randomIntArray(int limit = 10){
        return IntStream.iterate(randomInt(), a -> randomInt()).limit(limit).toArray();
    }

    private static int randomInt(){
        int MIN = -30;
        int MAX = -MIN;
        return MIN + (int)(Math.random() * ((MAX - MIN) + 1));
    }

    private static void testIt(int[] A){
        Solution sol = new Solution();

        System.out.println(String.format("\n\nInitial Array: %s", Arrays.toString(A)));

        int badComplexity = sol.badSolution(A);
        int goodComplexity = sol.solution(A);

        System.out.println(String.format("Results\n badSolution: %s, solution: %s",
                badComplexity,
                goodComplexity));

    }

    public int solution(int[] A) {
        System.out.println("Solution");
        int[] cumulativeSum = new int[A.length+1];
        cumulativeSum[0] = 0;
        cumulativeSum[1] = A[0];
        for (int i = 1; i < A.length; i++) {
            cumulativeSum[i+1] = cumulativeSum[i] + A[i];
        }
        System.out.println(String.format(" CumulativeSum: %s", Arrays.toString(cumulativeSum)));

        int indexOfMax = 1;
        for ( int i = 1; i < cumulativeSum.length; i++ )
        {
            if ( cumulativeSum[i] > cumulativeSum[indexOfMax] ) indexOfMax = i;
        }

        int indexOfMin = 0;
        for ( int i = 0; i < indexOfMax; i++ )
        {
            if (cumulativeSum[i] < cumulativeSum[indexOfMin] ) indexOfMin = i;
        }
        System.out.println(String.format(" Min index %s , Max index %s", indexOfMin, indexOfMax));
        return cumulativeSum[indexOfMax] - cumulativeSum[indexOfMin];
    }


    private  int badSolution(int[] A){
        System.out.println("Bad Solution");
        int P = 0;
        int Q = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int currSum = Arrays.stream(Arrays.copyOfRange(A, i, j+1)).sum();
                if (currSum > max) {
                    max = currSum;
                    P = i;
                    Q = j;
                }
            }
        }
        System.out.println(String.format(" Best slice is (%s, %s)", P, Q));
        return max;
    }
}