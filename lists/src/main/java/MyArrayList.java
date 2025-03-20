
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

    //region removeMethods
    public boolean removeByIndex(int index) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {

            if (i == index){
                flag = true;
            }

            if (flag){
                objects[i] = objects[i+1];
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean removeElement(Object element) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {

            if (objects[i].equals(element)){
                flag = true;
            }

            if (flag){
                objects[i] = objects[i+1];
            }
        }
        size--;
        return true;
    }

    public boolean removeFirst(){

        for (int i = 0; i < size; i++) {
            objects[i] = objects[i+1];
        }

        objects[size-1] = null;
        size--;
        return true;
    }
    //endregion

    public int getSize(){
        return size;
    }

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
        return objects[index];
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

    public void printCollection(){
        for (int i = 0; i < size; i++) {
            System.out.println(objects[i]);
        }
    }

}