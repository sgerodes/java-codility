/*
        Task description
        You are given N counters, initially set to 0, and you have two possible operations on them:

        increase(X) − counter X is increased by 1,
        max counter − all counters are set to the maximum value of any counter.
        A non-empty array A of M integers is given. This array represents consecutive operations:

        if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
        if A[K] = N + 1 then operation K is max counter.
        For example, given integer N = 5 and array A such that:

            A[0] = 3
            A[1] = 4
            A[2] = 4
            A[3] = 6
            A[4] = 1
            A[5] = 4
            A[6] = 4
        the values of the counters after each consecutive operation will be:

            (0, 0, 1, 0, 0)
            (0, 0, 1, 1, 0)
            (0, 0, 1, 2, 0)
            (2, 2, 2, 2, 2)
            (3, 2, 2, 2, 2)
            (3, 2, 2, 3, 2)
            (3, 2, 2, 4, 2)
        The goal is to calculate the value of every counter after all operations.

        Write a function:

        class Solution { public int[] solution(int N, int[] A); }

        that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

        Result array should be returned as an array of integers.

        For example, given:

            A[0] = 3
            A[1] = 4
            A[2] = 4
            A[3] = 6
            A[4] = 1
            A[5] = 4
            A[6] = 4
        the function should return [3, 2, 2, 4, 2], as explained above.

        Write an efficient algorithm for the following assumptions:

        N and M are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..N + 1].


 */
/*
        SCORE: 100 / 100 / 100
        Time Complexity: O(N+M)
        Space Complexity: O(N)

        Solution description:
        - Create the counter Array
        - Store the maximum of allready seen elements in the Array (currentMax)
        - appliedMax is the currentMax to the time of the last applience of  the "max counter" rule
        Algorithm:
        - Iterate throug the imput array
        - if "max counter" rule: elevate appliedMax to the value of currentMax
        - else increment according counter,
            but first check if the current counter should be elevated to the level of appliedMax
            adjust currentMax if needed
        - iterate over Counter Array. Adjust counter if it is smaller than appliedMax

 */

class Solution {
    public int[] solution(int N, int[] A) {
        int currentMax = 0;
        int appliedMax = 0;
        int[] counters = new int[N];
        for (int elem : A){
            if (elem == N + 1){
                appliedMax = currentMax;
            } else {
                int counterIndex = elem - 1;
                if (counters[counterIndex] < appliedMax) counters[counterIndex] = appliedMax;
                counters[counterIndex]++;
                if (counters[counterIndex] > currentMax) currentMax = counters[counterIndex];
            }
        }
        for (int i = 0; i < counters.length; ++i){
            if (counters[i] < appliedMax){
                counters[i] = appliedMax;
            }
        }
        return counters;
    }
}