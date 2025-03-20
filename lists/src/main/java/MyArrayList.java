public class MyArrayList <T extends Comparable<T>> implements MyList{

    private final int CAPACITY = 10;
    private int size = 0;
    private Object[] objects;

    //region constructors
    public MyArrayList(int givenCapacity){
        objects = (T[]) new Comparable[givenCapacity];
    }

    public MyArrayList(){
        objects = (T[]) new Comparable[CAPACITY];
    }

    public MyArrayList(Object[] array){
        objects = (T[]) new Comparable[array.length];

        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
            size++;
        }
    }

    //endregion


    public boolean isEmpty(){
        return objects.length == 0;
    }

    public Object getByIndex(int index){
        return objects[index];
    }

    public boolean removeByIndex(int index) {
        objects[index] = 0;
        return true;
    }

    public int getSize(){
        return size;
    }


    //region MyListMethods
    @Override
    public boolean add(Object element) {
        objects[size] = element;
        size++;

        return true;
    }

    @Override
    public boolean addByIndex(int index, Object element) {
        if (index >= size){
            System.out.println("Index out of bounds");
            return false;
        }

        objects[index] = element;
        size++;

        return true;
    }

    @Override
    public Object getElementByIndex(int index) {
        return null;
    }

    @Override
    public boolean removeElement(Object element) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(element)){
                objects[i] = 0;
            }
        }
        return true;
    }

    @Override
    public boolean clearCollection() {
        for (int i = 0; i < size; i++) {
            objects[i] = 0;
        }
        return true;
    }

    @Override
    public boolean sortCollection() {
        return false;
    }
    //endregion
}
