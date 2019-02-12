/*

 */
/*
        SCORE:   / 100 / 50
        Time Complexity: O(1)
        Space Complexity: O(1)

        Solution description:

 */

class Solution {
    public int solution(int A, int B, int K) {
        return ((B-A) - (A%K) + K) / K ;
    }
}