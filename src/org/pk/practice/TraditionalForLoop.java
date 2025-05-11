package org.pk.practice;

public class TraditionalForLoop {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};

        System.out.println("Max value " + max(new Integer[]{3, 5, 6}));
        System.out.println("Min value " + min(new Integer[]{3, 5, 6}));
        System.out.println();

        System.out.println("Max value " + max(arr));
        System.out.println("Min value " + min(arr));
        System.out.println("Sum value " + sum(arr));
        System.out.println("Average value " + average(arr));
    }

    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (T no : arr) {
            if (max.compareTo(no) < 0) {
                max = no;
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T min(T[] arr) {
        T max = arr[0];
        for (T no : arr) {
            if (max.compareTo(no) > 0) {
                max = no;
            }
        }
        return max;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int no : arr) {
            if (max < no) {
                max = no;
            }
        }
        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int no : arr) {
            if (min > no) {
                min = no;
            }
        }
        return min;
    }

    public static long sum(int[] arr) {
        long sum = 0;
        for (int no : arr) {
            sum += no;
        }
        return sum;
    }

    public static long average(int[] arr) {
        long sum = 0;
        for (int no : arr) {
            sum += no;
        }
        return sum / arr.length;
    }
}
