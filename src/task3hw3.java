/*
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */

import java.util.*;

public class task3hw3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            arr.add(rnd.nextInt(100));
        }
        System.out.println(arr);
        System.out.printf("Максимальный элемент списка = %s\n", Collections.max(arr));
        System.out.printf("Минимальный элемент списка = %s\n", Collections.min(arr));
        System.out.printf("Среднее арифметическое списка = %s\n", getAverage(arr) );
    }

    private static Object getAverage(ArrayList<Integer> arr) {
        return arr.stream().mapToInt(a -> a).average().orElse(0);
    }
}
