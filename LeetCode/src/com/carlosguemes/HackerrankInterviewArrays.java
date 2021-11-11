package com.carlosguemes;

import java.util.*;

public class HackerrankInterviewArrays {

    /**
     * ***********************
     * ARRAYS
     * ***********************
     */

    /**
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        Set<Integer> pairedSocks = new HashSet<>();
        int counter = 0;

        for (int i=0; i<n; i++) {
            if (pairedSocks.contains(ar.get(i))) {
                counter++;
                pairedSocks.remove(ar.get(i));
            } else {
                pairedSocks.add(ar.get(i));
            }
        }
        return counter;
    }

    /**
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */
    public static int jumpingOnClouds(List<Integer> c) {
        int jump = 0;

        for (int i=0; i<c.size()-1; i++) {
            jump++;
            int b = c.size()-2;
            if (i<c.size()-2 && c.get(i + 2) == 0) {
                i++;
            }
        }
        return jump;
    }

    /**
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
    public static long repeatedString(String s, long n) {
        long strLength = s.length();

        // Count the number of ´a´ in the given string
        int count = 0;
        for (int i = 0; i<strLength; i++) {
            if (s.charAt(i) == 'a') {
                ++count;
            }
        }

        long repeatedTimes = n / strLength;

        // Find the length of string left after repetitions
        long stringLeftLength = n - (strLength * repeatedTimes);

        // Count the remaining repetitions
        int extra = 0;
        for (int i = 0; i<stringLeftLength; i++) {
            if (s.charAt(i) == 'a') {
                ++extra;
            }
        }

        long totalCount = (repeatedTimes * count) + extra;

        return totalCount;
    }

    /**
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        int sum = -64;

        for (int column=0; column < 4; column++) {
            for (int row=0; row<4; row++) {
                int top= arr.get(row).get(column) + arr.get(row).get(column+1) + arr.get(row).get(column+2);
                int middle = arr.get(row + 1).get(column+1);
                int bottom = arr.get(row + 2).get(column) + arr.get(row + 2).get(column +1) + arr.get(row + 2).get(column+2);

                if ((top + middle + bottom) > sum) {
                    sum = top + middle + bottom;
                }
            }
        }
        return sum;
    }

    /**
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int position = a.size();
        int index = position -d -1;
        List<Integer> rotArray = new ArrayList<>(a);

        for (int i=0; i< index; i++) {
            rotArray.add(i, a.get(d));
            d++;
        }
        rotArray.add(index, a.get(a.size()-1));

        if (rotArray.size() > position) {
            rotArray.subList(position, rotArray.size()).clear();
        }


        return rotArray;
    }

    /**
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int ans = 0;
        for(int i=q.size()-1;i>=0;i--){
            int ch_pos = q.get(i)-(i+1);
            if(ch_pos>2) { System.out.println("Too chaotic");
                return; }
            else{
                //find starting index
                //range[num-2, arr.length] or 0 to length
                int st = Math.max(0,q.get(i)-2);
                for(int j=st;j<i;j++){
                    if(q.get(j)>q.get(i)) ans++;
                }
            }
        }
        System.out.println(ans);

    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps=0;
        int counter = 1;
        while (counter < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[i] && arr[j] == counter) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        swaps++;
                        counter++;
                    }
                }
            }
            counter++;
        }
        System.out.println(Arrays.toString(arr));
        return swaps;
    }




}
