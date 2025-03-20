
public class MyLinkedList <T extends Comparable<T>> implements MyList{

    private int size = 0;
    private Node<Object> head;
    private Node<Object> tail;

    //region constructors
    public MyLinkedList(){
        head = null;
        tail = null;
    }


    //endregion

    //region NodeClass
    private static class Node<T>{
        T element;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(MyLinkedList.Node<T> prev, T element, MyLinkedList.Node<T> next) {
            this.element = element;
            this.nextNode = next;
            this.prevNode = prev;
        }
    }
    //endregion


    //region addMethods
    @Override
    public boolean add(Object element) {
        Node<Object> node = new Node<>(null, element, null);
        if (head == null){
            head = tail = node;
        }
        else {
            tail.nextNode = node;
            node.prevNode = tail;
            tail = node;
        }
        size++;

        return true;
    }

    public boolean addFirst(Object element){
        Node<Object> node = new Node<>(null, element, null);
        node.nextNode = head;
        head.prevNode = node;
        head = node;

        size++;
        return true;
    }

    public boolean addLast(Object element){
        Node<Object> node = new Node<>(null, element, null);
        node.prevNode = tail;
        tail.nextNode = node;
        tail = node;

        size++;
        return true;
    }

    @Override
    public boolean addByIndex(int index, Object element) {

        if (index >= size){
            System.out.println("Index out of bound");
            return false;
        }

        Node<Object> node = new Node<>(null, element, null);

        Node<Object> current = head.nextNode;
        for (int i = 1; i < size; i++) {

            if (i == index){
                node.nextNode = current;
                node.prevNode = current.prevNode;
                current.prevNode = node;
                node.prevNode.nextNode = node;

                size++;
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    //endregion

    //region removeMethods
    @Override
    public boolean removeElement(Object element) {
        Node<Object> current = head;
        while (current != null){
            if (current.element == element){
                current.prevNode.nextNode = current.nextNode;
                current.nextNode.prevNode = current.prevNode;
                current.nextNode = null;
                current.prevNode = null;

                size--;
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    @Override
    public boolean removeByIndex(int index) {

        if (index == size-1){
            removeLast();
            return true;
        }

        Node<Object> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index){
                current.prevNode.nextNode = current.nextNode;
                current.nextNode.prevNode = current.prevNode;
                current.nextNode = null;
                current.prevNode = null;

                size--;
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public boolean removeLast(){
        Node<Object> current = tail;
        tail = current.prevNode;
        tail.nextNode = null;

        current.nextNode = null;
        current.prevNode = null;

        size--;
        return true;
    }

    public boolean removeFirst(){
        Node<Object> current = head;
        head = current.nextNode;
        head.prevNode = null;

        current.prevNode = null;
        current.nextNode = null;

        size--;
        return true;
    }
    //endregion

    @Override
    public Object getElementByIndex(int index) {
        Node<Object> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index){
                return current.element;
            }
            current = current.nextNode;
        }
        return null;
    }

    @Override
    public boolean clearCollection() {
        this.head = null;
        this.tail = null;
        this.size = 0;

        return true;
    }

    @Override
    public boolean sortCollection() {
        return false;
    }

    public void printCollection(){
        Node<Object> current = head;
        while (current != null){
            System.out.println(current.element);
            current = current.nextNode;
        }
    }

    public void printReverseCollection(){
        Node<Object> current = tail;
        while (current != null){
            System.out.println(current.element);
            current = current.prevNode;
        }
    }
}