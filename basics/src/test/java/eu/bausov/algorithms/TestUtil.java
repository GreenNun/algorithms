package eu.bausov.algorithms;

/**
 * Created by GreenNun on 2019-01-24.
 */
public class TestUtil {
    public static boolean isSortedArray(int[] arr) {
        if (arr.length == 1)
            return true;

        int value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < value)
                return false;
        }

        return true;
    }
}
