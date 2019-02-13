/*
        Task description
        Write a function:

        class Solution { public int solution(int A, int B, int K); }

        that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

        { i : A ≤ i ≤ B, i mod K = 0 }

        For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

        Write an efficient algorithm for the following assumptions:

        A and B are integers within the range [0..2,000,000,000];
        K is an integer within the range [1..2,000,000,000];
        A ≤ B.
 */
/*
        SCORE:   / 100 / 50
        Time Complexity: O(1)
        Space Complexity: O(1)

        Solution description:

 */


class Solution {
    public int solution(int A, int B, int K) {
        // wrong for [1, 1, 1]
        int n = B - A + 1;
        int gapA = ((K - A) % K + K) % K ;
        int gapB = B % K;
        if (A + gapA > B){
            return 0;
        }
        return (n - gapA - gapB) / K + 1;
    }
}
