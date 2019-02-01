/*
        Task description
        This is a demo task.

        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

        Given A = [1, 2, 3], the function should return 4.

        Given A = [−1, −3], the function should return 1.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
/*
        SCORE: 100 / 100 / 100
        Time Complexity: O(n)
        Space Complexity: O(n)

        Solution description:
        - iterate through the aray and search if numbers in range [1, N] occur. Numebers outside the range are irrelevant
        - iterate through the occurences array. If some value is missing it is the first missing number.
 */


class Solution {
    public int solution(int[] A) {
        boolean[] occurences = new boolean[A.length + 2];
        for (int i : A){
            if (i <= A.length && i > 0){
                occurences[i] = true;
            }
        }
        for (int i = 1; i < occurences.length; ++i){
            if (!occurences[i]){
                return i;
            }
        }
        return -1;
    }
}