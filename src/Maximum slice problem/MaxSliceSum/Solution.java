import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int solution(int[] A) {
        int maxEnding = 0;
        int maxSlice = 0;

        for (int num : A) {
            maxEnding = Math.max(0, maxEnding + num);
            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }

}
