package javabook;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class BubbleSort {

    public void bubbleSort(int[] numbers) {
        boolean numbersSwitched;

        do {
            numbersSwitched = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] < numbers[i]) {
                    int tmp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = tmp;
                    numbersSwitched = true;
                }
            }
        } while (numbersSwitched);
    }

    @Test
    public void sortTest() {
        int[] test = {9, 5, 4, -1, 5, 6};

        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(test);

        int[] res = {-1, 4, 5, 5, 6, 9};

        assertArrayEquals(res, test);
    }
}