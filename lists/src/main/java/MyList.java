public interface MyList<T> {

    boolean add(T element);

    boolean addByIndex(int index, T element);

    Object getElementByIndex(int index);

    boolean removeElement(T element);

    boolean removeByIndex(int index);

    boolean clearCollection();

    boolean sortCollection();
}
