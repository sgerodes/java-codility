/*
        Task description
        A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

        S is empty;
        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.
        For example, the string "{[()()]}" is properly nested but "([)()]" is not.

        Write a function:

        class Solution { public int solution(String S); }

        that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

        For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..200,000];
        string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/

/*
        SCORE:  100 / 100 / 100
        Time Complexity: O(n)
        Space Complexity: O(n)

        Solution description:
        - make an Stack
        - if oppening bracket push on Stack
        - if closing pop stack and check if the current and poped bracket matches

        Explanation of areMatching method
        Chars can be substractet like ints.
        The matching brackets are always no more than 2 characters away from each other.
        For more information check the ASCII table.
        '(' - ')' == 1
        '{' - '}' == 2
        '[' - ']' == 2

 */

import java.util.Stack;

class Solution {

    private String oppeningBrackets = "([{";

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : S.toCharArray()){
            if (isOppening(bracket)){
                stack.push(bracket);
            } else {
                if(stack.isEmpty() || !areMatching(stack.pop(), bracket)) return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    private boolean isOppening(char bracket){
        return oppeningBrackets.indexOf(bracket) >= 0;
    }

    private boolean areMatching(char bracket1, char bracket2){
        return Math.abs(bracket1 - bracket2) < 3;
    }
}