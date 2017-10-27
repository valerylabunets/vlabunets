package ru.job4j.array;


import java.util.Arrays;

public class BubbleSort {
    /**
     * Method sort.
     *
     * @param array - массив.
     * @return array - сортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                /**Сравниваем элементы попарно,
                   если они имеют неправильный порядок,
                   то меняем местами
                 */
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}

//        Arrays.sort(array);
//        for (int i = 0; i < array.length; i++) {
//            return array;

//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[i]) {
//                    int k = array[i];
//                    array[i] = array[j];
//                    array[j] = k;
