public interface MyList<T> {

    boolean add(T element);

    boolean addByIndex(int index, T element);

    T getElement(T element);

    boolean removeElement(T element);

    boolean clearCollection();

    boolean sortCollection();

}
