/*
        Task description
        A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

        For example, array A such that:

          A[0] = -3
          A[1] = 1
          A[2] = 2
          A[3] = -2
          A[4] = 5
          A[5] = 6
        contains the following example triplets:

        (0, 1, 2), product is −3 * 1 * 2 = −6
        (1, 2, 4), product is 1 * 2 * 5 = 10
        (2, 4, 5), product is 2 * 5 * 6 = 60
        Your goal is to find the maximal product of any triplet.

        Write a function:

        class Solution { public int solution(int[] A); }

        that, given a non-empty array A, returns the value of the maximal product of any triplet.

        For example, given array A such that:

          A[0] = -3
          A[1] = 1
          A[2] = 2
          A[3] = -2
          A[4] = 5
          A[5] = 6
        the function should return 60, as the product of triplet (2, 4, 5) is maximal.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [3..100,000];
        each element of array A is an integer within the range [−1,000..1,000].
*/

/*
        SCORE:  100 / 100 / 100
        Time Complexity: O(nlogn)
        Space Complexity: O(1)

        Solution description:
        - The answer would be the product of the 3 most biggest numbers in the array.
            Except if the absolute value two lowest numbers are biger than the second and third biggest and
            both are below zero (the minus signs are negated)
            and there should be a positive number in the array
        - sort
        - check the condition dicussed before if
            - false: mutiply the last three (the biggest three) numbers and return the value
            - true: check what is bigger the üroduct of two lowest or second and third highest and
                multiply the result it with the highest number
 */

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int last = A.length - 1;

        if (A[last] > 0 && A[0] < 0 && A[1] < 0) {
            int prodSecondThirdBiggest = A[last - 1] * A[last - 2];
            int prodTwoSmallest = A[0] * A[1];
            return A[last] * Math.max(prodTwoSmallest, prodSecondThirdBiggest);
        }

        return Arrays.stream(Arrays.copyOfRange(A, A.length - 3, A.length)).reduce(1, (a, b) -> a * b);
    }
}


/*
        SCORE:  100 / 100 / 100
        Time Complexity: O(n)
        Space Complexity: O(1)

        Solution description:
        - The algorithm is the same as before, but
            we calculate the MINs and MAXes in O(n) time complexity instead of sorting
 */

class Solution {
    public int solution(int[] A) {

        int[] twoSmallestAndThreeBiggest = calculateSmallestAndBiggest(A);

        int biggest = twoSmallestAndThreeBiggest[4];
        int secondBiggest = twoSmallestAndThreeBiggest[3];
        int thirdBiggest = twoSmallestAndThreeBiggest[2];
        int secondSmallest = twoSmallestAndThreeBiggest[1];
        int smallest = twoSmallestAndThreeBiggest[0];


        if (biggest > 0 && smallest < 0 && secondSmallest < 0) {
            int prodSecondThirdBiggest = secondBiggest * thirdBiggest;
            int prodTwoSmallest = smallest * secondSmallest;
            return biggest * Math.max(prodTwoSmallest, prodSecondThirdBiggest);
        }

        return biggest * secondBiggest * thirdBiggest;
    }

    private int[] calculateSmallestAndBiggest(int[] A) {

        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;
        int thirdBiggest = Integer.MIN_VALUE;

        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int num : A) {
            if (num >= thirdBiggest) {
                if (num >= secondBiggest) {
                    thirdBiggest = secondBiggest;
                    if (num >= biggest) {
                        secondBiggest = biggest;
                        biggest = num;
                    } else {
                        secondBiggest = num;
                    }
                } else {
                    thirdBiggest = num;
                }
            }
            if (num <= secondSmallest) {
                if (num <= smallest) {
                    secondSmallest = smallest;
                    smallest = num;
                } else {
                    secondSmallest = num;
                }
            }

        }
        return new int[]{smallest, secondSmallest, thirdBiggest, secondBiggest, biggest};
    }
}