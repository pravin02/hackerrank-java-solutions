package org.pk.hackerrank.datastructure;

import java.util.*;

public class DequeProblemSolution {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int noOfElements = Integer.parseInt(sc.next());
//        int sizeOfSubArray = Integer.parseInt(sc.next());
//        Deque<Integer> deque = new ArrayDeque<>(noOfElements);
//        while(noOfElements > 0){
//            deque.push(Integer.parseInt(sc.next()));
//            --noOfElements;
//        }
//        sc.close();
//        long max = maxUniqueIntegers(deque, sizeOfSubArray);
//        System.out.println(max);
//    }

    public static void main(String[] args) {
        String str = """
                6 3
                5 3 5 2 3 2
                """;
        String[] lines = str.split("\n");
        String[] firstRow = lines[0].split(" ");
        int noOfElements = Integer.parseInt(firstRow[0]);
        int sizeOfSubArray = Integer.parseInt(firstRow[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        int[] elements = new int[noOfElements];
        String[] data = lines[1].split(" ");
        for (int i = 0; i < noOfElements; i++) {
            elements[i] = Integer.parseInt(data[i]);
            deque.add(elements[i]);
        }
        long max = maxUniqueIntegers(deque, sizeOfSubArray);
        long max2 = maxUniqueIntegers2(deque, sizeOfSubArray);
        long max3 = maxUniqueIntegers3(elements, sizeOfSubArray);
        System.out.println(max);
        System.out.println(max2);
        System.out.println(max3);
    }

    // Solution 1
    public static Long maxUniqueIntegers(Deque<Integer> deque, int sizeOfSubArray) {
        List<List<Integer>> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> subArray = new ArrayList<>(sizeOfSubArray);
            for (int j = 0; j < sizeOfSubArray; j++) {
                Integer element = deque.poll();
                subArray.add(element);
            }
            list.add(subArray);
            // below reversed() method works on JDK23
//            for (Integer element : subArray.reversed()) {
//                deque.addFirst(element);
//            }
            // below is the workaround for below JDK23
            List<Integer> l = new ArrayList<>(subArray);
            Collections.reverse(l);
            for (Integer element : subArray) {
                deque.addFirst(element);
            }
            deque.pollFirst();
            if (deque.size() < sizeOfSubArray) break;
        }
        return list.stream().map(DequeProblemSolution::getDistinctCount).max(Long::compareTo).orElse(0L);
    }

    // Solution 2
    public static Long maxUniqueIntegers2(Deque<Integer> deque, int sizeOfSubArray) {
        List<List<Integer>> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> subArray = new ArrayList<>(sizeOfSubArray);
            int i = 0;
            for (Integer element : deque) {
                i++;
                subArray.add(element);
                if (i == sizeOfSubArray) {
                    break;
                }
            }
            list.add(subArray);
            deque.pollFirst();
            if (deque.size() < sizeOfSubArray) {
                break;
            }
        }
        return list.stream().map(DequeProblemSolution::getDistinctCount).max(Long::compareTo).orElse(0L);
    }

    public static int maxUniqueIntegers3(int[] arr, int sizeOfSubArray) {
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int maxUnique = 0;
        for (int i = 0; i < arr.length; i++) {
            if (deque.size() == sizeOfSubArray) {
                int removed = deque.removeFirst();
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
            deque.addLast(arr[i]);
            set.add(arr[i]);
            maxUnique = Math.max(maxUnique, set.size());
        }
        return maxUnique;
    }

    public static Long getDistinctCount(List<Integer> integers) {
        return integers.stream().distinct().count();
    }
}
