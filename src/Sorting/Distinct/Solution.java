/*
		Task description
		Write a function

		class Solution { public int solution(int[] A); }

		that, given an array A consisting of N integers, returns the number of distinct values in array A.

		For example, given array A consisting of six elements such that:

		 A[0] = 2    A[1] = 1    A[2] = 1
		 A[3] = 2    A[4] = 3    A[5] = 1
		the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

		Write an efficient algorithm for the following assumptions:

		N is an integer within the range [0..100,000];
		each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

/*
        SCORE:  100 / 100 / 100
        Time Complexity: O(n)
        Space Complexity: O(n)

        Solution description:
        - create Set of the array
        - the Set automatically stores only distinct vallues

 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> distinct = new HashSet<>();
        for (int i : A) distinct.add(i);
        return distinct.size();
    }
}


/*
        SCORE:  100 / 100 / 100
        Time Complexity: O(nlogn)
        Space Complexity: O(1)

        Solution description:
        - sort Array
        - if array.length != 0, start by 1 distinct, because the first value is not counted in the loop
        - iterate and count changes in the sequence

 */
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A.length == 0) return 0;
        Arrays.sort(A);
        int distinct = 1;
        for (int i = 0; i < A.length - 1; ++i){
            if (A[i] != A[i+1]) {
                ++distinct;
            }
        }
        return distinct;
    }
}