public class MergeSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void mergeSortMyLinkedList(MyLinkedList<T> myLinkedList) {
        int inputLength = myLinkedList.getSize();

        if (inputLength <= 1) {
            return;
        }

        int midIndex = inputLength / 2;
        MyLinkedList leftHalf = new MyLinkedList<>();
        for (int i = 0; i < midIndex; i++) {
            leftHalf.add(myLinkedList.getElementByIndex(i));
        }

        MyLinkedList rightHalf = new MyLinkedList<>();
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf.add(myLinkedList.getElementByIndex(i));
        }

        mergeSortMyLinkedList(leftHalf);
        mergeSortMyLinkedList(rightHalf);

        merge(myLinkedList, leftHalf, rightHalf);

    }

    private static <T extends Comparable<T>> void merge(MyLinkedList myLinkedList, MyLinkedList leftHalf, MyLinkedList rightHalf) {
        int leftSize = leftHalf.getSize();
        int rightSize = rightHalf.getSize();

        int leftI = 0; // i
        int rightI = 0; // j
        int mergeI = 0; // k

        while (leftI < leftSize && rightI < rightSize) {
            if (leftHalf.getElementByIndex(leftI).compareTo(rightHalf.getElementByIndex(rightI)) <= 0) {
                myLinkedList.swapByIndex(mergeI, leftHalf.getElementByIndex(leftI));
                leftI++;
            } else {
                myLinkedList.swapByIndex(mergeI, rightHalf.getElementByIndex(rightI));
                rightI++;
            }
            mergeI++;
        }

        while (leftI < leftSize) {
            myLinkedList.swapByIndex(mergeI, leftHalf.getElementByIndex(leftI));
            leftI++;
            mergeI++;
        }
        while (rightI < rightSize) {
            myLinkedList.swapByIndex(mergeI, rightHalf.getElementByIndex(rightI));
            rightI++;
            mergeI++;
        }
    }

}