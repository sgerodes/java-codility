/*
        Task description
        An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

        Your goal is to find that missing element.

        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A, returns the value of the missing element.

        For example, given array A such that:

          A[0] = 2
          A[1] = 3
          A[2] = 1
          A[3] = 5
        the function should return 4, as it is the missing element.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        the elements of A are all distinct;
        each element of array A is an integer within the range [1..(N + 1)].

 */

/*
    SCORE: 100 / 100 / 100
    Time Complexity: O(n)
    Space Complexity: O(1)

    Solution description:
    The sequence of numbers will be up to the number N + 1 with one missing number. 
    - We sum up all numbers from 1 to N + 1.
    - Then iterating through the array we subtract the current element from the sum. The rest in the sum will be the
    missing number.

    Notice:
    Use long for the sum. Using int with a big N there is an overflow posssible.
 */

class Solution {
    public int solution(int[] A) {
        long biggestNumber = A.length + 1;
        long sum = biggestNumber * (biggestNumber + 1 ) / 2;
        for (int i : A){
            sum -= i;
        }
        return (int)sum;
    }
}
