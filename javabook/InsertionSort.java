package javabook;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class InsertionSort {

    public static List<Integer> insertSort(final List<Integer> numbers) {
        final List<Integer> sortedList = new LinkedList<>();
        
        originalList: for (Integer number : numbers) {
            for (int i = 0; i < sortedList.size(); i++) {
                if (number < sortedList.get(i)) {
                    sortedList.add(i, number);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }
        return sortedList;
    }

    @Test
    public void sortTest() {
        final List<Integer> test = Arrays.asList(9, 5, 4, -1, 5, 6);

        final List<Integer> ans = insertSort(test);

        final List<Integer> res = Arrays.asList(-1, 4, 5, 5, 6, 9);

        assertEquals(res, ans);
    }
}