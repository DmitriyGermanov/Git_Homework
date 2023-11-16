import java.util.Arrays;
/*
Сначала выводить исходный массив на экран.

Затем применять сортировку кучей (Heap Sort) для сортировки элементов
массива в порядке возрастания.

Выводить отсортированный массив на экран.

Ваше решение должно содержать два основных метода: buildTree, который
строит сортирующее дерево на основе массива, и heapSort, который выполняет
собственно сортировку кучей. Основная часть кода предоставлена вам.

Программа должна быть способной сортировать массив, даже если он состоит из
отрицательных чисел и имеет дубликаты.
*/

class HeapSort {
    public static void buildTree(int[] sortArray, int sortLength, int i) {
        // Введите свое решение ниже
        int larg = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < sortLength && sortArray[larg] < sortArray[left]) {
            larg = left;
        }
        if (right < sortLength && sortArray[larg] < sortArray[right]) {
            larg = right;
        }
        if (larg != i) {
            int temp = sortArray[larg];
            sortArray[larg] = sortArray[i];
            sortArray[i] = temp;
            buildTree(sortArray, sortLength, larg);
        }

    }


    public static void heapSort(int[] sortArray, int sortLength) {
// Введите свое решение ниже
        int len = sortLength / 2;
        for (int i = len - 1; i >= 0; i--) {
            buildTree(sortArray, sortLength, i);
        }
        for (int i = sortLength - 1; i >= 0; i--) {
            int temp = sortArray[i];
            sortArray[i] = sortArray[0];
            sortArray[0] = temp;
            buildTree(sortArray, i, 0);
        }
    }
}
// Не удаляйте и не меняйте метод Main!
public class Main {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}