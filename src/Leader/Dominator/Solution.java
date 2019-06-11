/*
        Task description
        An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

        For example, consider array A such that

         A[0] = 3    A[1] = 4    A[2] =  3
         A[3] = 2    A[4] = 3    A[5] = -1
         A[6] = 3    A[7] = 3
        The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

        Write a function

        class Solution { public int solution(int[] A); }

        that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

        For example, given array A such that

         A[0] = 3    A[1] = 4    A[2] =  3
         A[3] = 2    A[4] = 3    A[5] = -1
         A[6] = 3    A[7] = 3
        the function may return 0, 2, 4, 6 or 7, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

 */
/*
        SCORE:  100 / 100 / 100
        Time Complexity: O(n)
        Space Complexity: O(n)

        Solution description:

        - create a  Map Data Structure with the keys beeing the elements in the array.
            The values beeing an array (first element is the occurence count of the element, second is the index of the first occurence in the initial array A)
        - Loop through A and count elements, storing the first occurences to the element
        - At the time you hit an element that occured half of the time return it
 */

class Solution {
    public int solution(int[] A) {
        int solution(int[] A) {

            int half = A.length / 2;

            // Map elment -> [occurences, firstFoundElement]
            HashMap<Integer, int[]> counter = new HashMap<>();

            int[] current;
            int element;
            for (int i = 0; i < A.length; ++i) {
                element = A[i];
                counter.putIfAbsent(element, new int[] {0, i});
                current = counter.get(element);
                if (current[0] == half) {
                    return current[1];
                }
                current[0]++;
            }
            return -1;
        }

    }
}
