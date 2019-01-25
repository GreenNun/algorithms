package eu.bausov.algorithms.basics.mergesrot;

import eu.bausov.algorithms.TestUtil;
import eu.bausov.algorithms.basics.mergesrot.impl.MergeSortImpl;
import eu.bausov.algorithms.basics.util.Tuple2;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by GreenNun on 2019-01-24.
 */
public class MergeSortTest {
    private final int[] integers = {0, 6, 5, 4, 3, 2, 1, 1};

    @Test
    public void sort() {
        final int[] sorted = new MergeSortImpl().sort(integers);

        System.out.println("sort");
        System.out.println(Arrays.toString(integers) + " -> " + Arrays.toString(sorted));

        assertTrue(TestUtil.isSortedArray(sorted));
        assertEquals("[0, 1, 1, 2, 3, 4, 5, 6]", Arrays.toString(sorted));
    }

    @Test
    public void splitArray() {
        final Tuple2<int[], int[]> tuple2 = new MergeSortImpl().splitArray(integers);

        System.out.println("split");
        System.out.println(Arrays.toString(integers) + " -> " + Arrays.toString(tuple2.getFirst()) + " " + Arrays.toString(tuple2.getSecond()));

        final int[] first = tuple2.getFirst();
        assertEquals(first[0], integers[0]);
        assertEquals(first[1], integers[1]);
        assertEquals(first[2], integers[2]);
        assertEquals(first[3], integers[3]);

        final int[] second = tuple2.getSecond();
        assertEquals(second[0], integers[4]);
        assertEquals(second[1], integers[5]);
        assertEquals(second[2], integers[6]);
        assertEquals(second[3], integers[7]);
    }

    @Test
    public void mergeSorted() {
        final MergeSortImpl mergeSort = new MergeSortImpl();
        final int[] merge = mergeSort.mergeSorted(new int[]{1, 3, 5, 7}, new int[]{0, 0, 2, 4, 5, 6});

        System.out.println("merge sorted");
        System.out.println("[1, 3, 5, 7] [0, 0, 2, 4, 5, 6] -> " + Arrays.toString(merge));

        assertEquals("[0, 0, 1, 2, 3, 4, 5, 5, 6, 7]", Arrays.toString(merge));
    }

    @Test
    public void mergeSorted1() {
        final MergeSortImpl mergeSort = new MergeSortImpl();
        final int[] merge = mergeSort.mergeSorted(new int[]{2, 3}, new int[]{1, 1});

        assertEquals("[1, 1, 2, 3]", Arrays.toString(merge));
    }
}