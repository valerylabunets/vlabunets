package ru.job4j.array;

import java.util.Arrays;

public class ArraysMerge {
    /**
     * Method merge.
     *
     * @param left - массив.
     * @param right - массив.
     * @return combined - объединенный массив.
     */
    int[] merge(int[] left, int[] right) {
        int[] combined = new int[left.length + right.length];
        int aI = 0;
        int bI = 0;
        int i = 0;
        while (i < combined.length) {
            if (aI == left.length && bI < right.length) {
                combined[i] = right[bI++];
            } else if (bI == right.length && aI < left.length) {
                combined[i] = left[aI++];
            } else if (bI == right.length && aI == left.length) {
                break;
            } else if (left[aI] < right[bI]) {
                combined[i] = left[aI++];
            } else if (left[aI] == right[bI]) {
                combined[i] = right[bI++];
                aI++;
            } else if (left[aI] > right[bI]) {
                combined[i] = right[bI++];
            }
            i++;
        }
        int[] result = new int[i];
        System.arraycopy(combined, 0, result, 0, i);

        System.out.println("result:" + Arrays.toString(result));
        return combined;
    }
}