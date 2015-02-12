package pl.arkadiuszbicz;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] values = {4, 9, 6, 1, 7, 3, 2, 39, 13, 34, 4, 5};
        Arrays.sort(values);
        int[] valuesWithoutDuplicates = new int[values.length];
        valuesWithoutDuplicates[0] = values[0];
        for(int i=1, l=1; i < values.length; i++) {
            if(values[i]!=values[i-1]) {
                valuesWithoutDuplicates[l] = values[i];
                l++;

            }
        }

        System.out.println(Arrays.toString(valuesWithoutDuplicates));
        System.out.println(binarySearch(valuesWithoutDuplicates, 0) + " " + binarySearch(valuesWithoutDuplicates, 100));
        for(int i = 0; i < (valuesWithoutDuplicates.length-1); i++)
         System.out.println(binarySearch(valuesWithoutDuplicates, valuesWithoutDuplicates[i]));
    }

    static int binarySearch(int[] values, int value) {
        int l =0;
        int k = values.length-1;
        int result = -1;
        while(l<=k && result == -1) {
            int m = (k - l) / 2 + l;
            if(values[m] > value) k = m-1;
            else if (values[m] < value) l = m+1;
            else result = m;
        }
        return result;
    }
}
