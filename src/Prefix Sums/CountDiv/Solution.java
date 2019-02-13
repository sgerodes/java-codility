/*

 */
/*
        SCORE:   / 25 / 25
        Time Complexity: O(1)
        Space Complexity: O(1)

        Solution description:

 */

class Solution {
    public int solution(int A, int B, int K) {
        int n = B - A + 1;
        int gapA = (K - A) % K;
        int gapB = B % K;
        if (n + gapA > B){
            return 0;
        }
        return (n - gapA - gapB) / K + 1;
    }
}