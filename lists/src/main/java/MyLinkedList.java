public class MyLinkedList  <T extends Comparable<T>> implements MyList{

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


    @Override
    public boolean add(Object element) {
        Node<Object> node = new Node<>(null, element, null);
        if (head == null){
            head = node;
        }
        else {
            tail.nextNode = node;
            node.prevNode = tail;
            tail = node;
        }
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
        if (index == 0){
            head = node;
        }
        else {
            Node<Object> current = head;
            for (int i = 0; i < size; i++) {
                if (i == index){
                    node.prevNode = current.prevNode;
                    node.nextNode = current.nextNode;
                }
                current = current.nextNode;
            }
        }
        return false;
    }

    @Override
    public Object getElement(Object element) {
        Node<Object> current = head;
        while (current != null){
            if (current.element == element){
                return element;
            }
            current = current.nextNode;
        }
        return null;
    }

    @Override
    public boolean removeElement(Object element) {
        Node<Object> current = head;
        while (current != null){
            if (current.element == element){
                current.prevNode = current.nextNode;
                size--;
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    @Override
    public boolean clearCollection() {
        head = null;
        tail = null;
        size = 0;

        return true;
    }

    @Override
    public boolean sortCollection() {
        return false;
    }

}