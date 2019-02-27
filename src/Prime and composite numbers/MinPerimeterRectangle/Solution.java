/*
        Task description
        An integer N is given, representing the area of some rectangle.

        The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

        The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

        For example, given integer N = 30, rectangles of area 30 are:

        (1, 30), with a perimeter of 62,
        (2, 15), with a perimeter of 34,
        (3, 10), with a perimeter of 26,
        (5, 6), with a perimeter of 22.
        Write a function:

        class Solution { public int solution(int N); }

        that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

        For example, given an integer N = 30, the function should return 22, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..1,000,000,000].
 */

/*
        SCORE:
        Time Complexity: O(sqrt(n))
        Space Complexity: O(1)
        Solution description:
        - we search a tuple of integers that multiplied give us N and added are minimal
        - the first tuple would be the smallest one ( 1 * N), and the last would be smallest, so lets search fo the last
        - apply the algorithm from CountFactors to find the last one is O(sqrt(N))

 */

class Solution {

    public int solution(int N) {

        int flooredSqrt = (int)Math.sqrt(N);

        for (int i = flooredSqrt; i >= 1 ; --i){

            if (N % i == 0){
                int length = N / i;
                int height = i;
                return  length * 2 + height * 2;
            }

        }

        return -1;
    }

}