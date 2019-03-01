/*
        Task description
        A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

        For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

        Write a function:

        class Solution { public int solution(int N); }

        that, given a positive integer N, returns the number of its factors.

        For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..2,147,483,647].
*/

/*
        SCORE:
        Time Complexity: O(sqrt(n))
        Space Complexity: O(1)
        Solution description:
        - count all factors up to sqrt(N), because if a number x is a factor, that means after sqrt(N) will be exactly
            one other number y that is a counterpart to x. x * y = N
        - double the number of factors
        - if N has a sqrt that is an integer than count this one only once
 */

class Solution {

    public int solution(int N) {

        int factors = 0;

        for (int i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                ++factors;
            }
        }

        factors *= 2;

        if (Math.pow(Math.floor(Math.sqrt(N)), 2) == N) {
            ++factors;
        }

        return factors;
    }

}