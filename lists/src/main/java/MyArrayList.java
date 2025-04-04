public class MyArrayList<T extends Comparable<T>> {

    private final int CAPACITY = 10;
    private int size = 0;
    private T[] objects;

    //region constructors
    public MyArrayList(int givenCapacity) {
        objects = (T[]) new Comparable[givenCapacity];
    }

    public MyArrayList() {
        objects = (T[]) new Comparable[CAPACITY];
    }

    public MyArrayList(T[] array) {
        objects = (T[]) new Comparable[array.length];

        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
            size++;
        }
    }

    //endregion

    public boolean isEmpty() {
        return objects.length == 0;
    }

    public T getByIndex(int index) {
        return objects[index];
    }

    //region removeMethods
    public boolean removeByIndex(int index) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {

            if (i == index) {
                flag = true;
            }

            if (flag) {
                objects[i] = objects[i + 1];
            }
        }
        size--;
        return true;
    }

    public boolean removeElement(Object element) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {

            if (objects[i].equals(element)) {
                flag = true;
            }

            if (flag) {
                objects[i] = objects[i + 1];
            }
        }
        size--;
        return true;
    }

    public boolean removeFirst() {

        for (int i = 0; i < size; i++) {
            objects[i] = objects[i + 1];
        }

        objects[size - 1] = null;
        size--;
        return true;
    }
    //endregion

    public int getSize() {
        return size;
    }

    public boolean add(T element) {
        objects[size] = element;
        size++;

        return true;
    }

    public boolean addByIndex(int index, T element) {
        if (index > size) {
            System.out.println("Index out of bounds");
            return false;
        }

        objects[index] = element;
        size++;

        return true;
    }

    public boolean changeByIndex(int index, T element) {
        if (index > size) {
            System.out.println("Index out of bounds");
            return false;
        }
        objects[index] = element;
        return true;
    }

    public T getElementByIndex(int index) {
        return objects[index];
    }

    public boolean clearCollection() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
        return true;
    }

    public boolean sortCollection(MyArrayList myArrayList) {
        QuickSort.quickSortMyArrayList(myArrayList);
        return true;
    }

    public void printCollection() {
        for (int i = 0; i < size; i++) {
            System.out.print(objects[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

}
