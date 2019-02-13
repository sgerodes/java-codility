/*

*/
/*
        SCORE:   / 100 / 20
        Time Complexity: O(n**2)
        Space Complexity: O(1)

        Solution description:

 */

class Solution {

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 5, 1, 5, 8};
        Solution solution = new Solution();
        //assert solution.solution(arr) == 0;
        System.out.println(solution.solution2(arr));
    }

    public int solution(int[] A) {
        int sliceSum = 0;
        int minIndex = Integer.MAX_VALUE;
        double absoluteMinAverage = Double.MAX_VALUE;
        double currentMinAverage;
        for (int i = 0; i < A.length - 1; ++i) {
            sliceSum = A[i];
            currentMinAverage = (A[i] + A[i + 1]) / 2.0;
            for (int j = i + 1; j < A.length; ++j) {
                sliceSum += A[j];
                currentMinAverage = Math.min(currentMinAverage, sliceSum / (j - i + 1.0));
            }
            if (currentMinAverage < absoluteMinAverage) {
                absoluteMinAverage = currentMinAverage;
                minIndex = i;
            }
        }
        return minIndex;
    }

}