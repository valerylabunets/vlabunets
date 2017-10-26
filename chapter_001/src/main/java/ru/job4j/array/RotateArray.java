package ru.job4j.array;

public class RotateArray {
    /**
     * Method rotate.
     * @param  array - массив.
     * @return array - повернутый на 90 градусов массив.
     */
    public int[][] rotate(int[][] array) {
        int n = array.length;
        int s = n / 2;
        for (int i = 0; i < s; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int k = array[i][j];
                array[i][j] = array[n - j - 1][i];
                array[n - j - 1][i] = array[n - i - 1][n - j - 1];
                array[n - i - 1][n - j - 1] = array[j][n - i - 1];
                array[j][n - i - 1] = k;
            }
        }
        return array;
    }
}
