package ru.job4j.array;

public class ArrayIsSort {
    /**
     * Method isSorted.
     * @param value - array.
     * @return is there array sorted.
     */
    boolean result = false;
    public boolean isSorted(int[] value) {
        for (int i = 0; i < value.length - 1; i++) {
            if (value[i] < value[i + 1]) {
                result = true;
            } else {
                System.out.println("Array is not sorted");
                result = false;
            }
            }
        return result;
    }
}
