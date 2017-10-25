package ru.job4j.array;

public class Turn {
    /**
     * Method back.
     * @param  array - массив.
     * @return array - перевернутый массив.
     */
    public int[] back(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int first = array[i];
            int last = array[array.length - i - 1];
            array[i] = last;
            array[array.length - i - 1] = first;
        }
        return array;
    }
}
