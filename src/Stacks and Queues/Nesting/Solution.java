/*
        Task description
        A string S consisting of N characters is called properly nested if:

        S is empty;
        S has the form "(U)" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.
        For example, string "(()(())())" is properly nested but string "())" isn't.

        Write a function:

        class Solution { public int solution(String S); }

        that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

        For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..1,000,000];
        string S consists only of the characters "(" and/or ")".
*/

/*
        SCORE:  100 / 100 / 100
        Time Complexity: O(n)
        Space Complexity: O(1)

        Solution description:
        - Check if the string has the same ammount of oppening brackets as closing, also you cant close if it was not oppened:
        - Iterate over the String:
            - if oppening increment diff else decrement
            - the diff cant be lower zero. Because e.g '))((' would than be valid
        - check if the diff is zero

 */

class Solution {

    public int solution(String S) {
        int diff = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '('){
                ++diff;
            } else {
                --diff;
            }
            if (diff < 0) return 0;
        }
        return diff == 0 ? 1 : 0;
    }
}