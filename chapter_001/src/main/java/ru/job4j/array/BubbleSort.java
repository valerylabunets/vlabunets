package ru.job4j.array;


public class BubbleSort {
    /**
     * Method sort.
     * @param  array - массив.
     * @return array - сортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
        return array;
    }
}