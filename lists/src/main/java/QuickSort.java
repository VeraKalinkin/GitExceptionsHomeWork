import java.util.Random;

public class QuickSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void quickSortMyArrayList(MyArrayList<T> myArrayList) {
        quickSortMyArrayList(myArrayList, 0, myArrayList.getSize() - 1);
    }

    private static <T extends Comparable<T>> void quickSortMyArrayList(MyArrayList<T> myArrayList, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = myArrayList.getByIndex(pivotIndex);
        swap(myArrayList, pivotIndex, highIndex);

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (myArrayList.getByIndex(leftPointer).compareTo(pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (myArrayList.getByIndex(rightPointer).compareTo(pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(myArrayList, leftPointer, rightPointer);

        }
        swap(myArrayList, leftPointer, highIndex);

        quickSortMyArrayList(myArrayList, lowIndex, leftPointer - 1);
        quickSortMyArrayList(myArrayList, leftPointer + 1, highIndex);
    }

    public static <T extends Comparable<T>> void swap(MyArrayList myArrayList, int index1, int index2) {
        T temp = (T) myArrayList.getByIndex(index1);
        myArrayList.changeByIndex(index1, myArrayList.getByIndex(index2));
        myArrayList.changeByIndex(index2, temp);
    }
}