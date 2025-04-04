public class MyLinkedList<T extends Comparable<T>> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    //region constructors
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    //endregion

    //region NodeClass
    private static class Node<T> {
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

    public int getSize() {
        return size;
    }

    //region addMethods
    public boolean add(T element) {
        Node<T> node = new Node<>(null, element, null);
        if (head == null) {
            head = tail = node;
        } else {
            tail.nextNode = node;
            node.prevNode = tail;
            tail = node;
        }
        size++;

        return true;
    }

    public boolean addFirst(T element) {
        Node<T> node = new Node<>(null, element, null);
        node.nextNode = head;
        head.prevNode = node;
        head = node;

        size++;
        return true;
    }

    public boolean addLast(T element) {
        Node<T> node = new Node<>(null, element, null);
        node.prevNode = tail;
        tail.nextNode = node;
        tail = node;

        size++;
        return true;
    }

    public boolean swapByIndex(int index, T element) {

        MyLinkedList myLinkedList = this;
        myLinkedList.getNodeByIndex(index).element = element;
        return true;
    }

    public boolean addByIndex(int index, T element) {

        if (index == 0) {
            add(element);
            return true;
        }

        Node<T> node = new Node<>(null, element, null);

        Node<T> current = head.nextNode;
        for (int i = 1; i < size; i++) {

            if (i == index) {
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
    public boolean removeElement(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.element == element) {
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

    public boolean removeByIndex(int index) {

        if (index == size - 1) {
            removeLast();
            return true;
        }

        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
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

    public boolean removeLast() {
        Node<T> current = tail;
        tail = current.prevNode;
        tail.nextNode = null;

        current.nextNode = null;
        current.prevNode = null;

        size--;
        return true;
    }

    public boolean removeFirst() {
        Node<T> current = head;
        head = current.nextNode;
        head.prevNode = null;

        current.prevNode = null;
        current.nextNode = null;

        size--;
        return true;
    }
    //endregion

    public T getElementByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return current.element;
            }
            current = current.nextNode;
        }
        return null;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return current;
            }
            current = current.nextNode;
        }
        return null;
    }

    public boolean clearCollection() {
        this.head = null;
        this.tail = null;
        this.size = 0;

        return true;
    }

    public boolean sortCollection(MyLinkedList myLinkedList) {
        MergeSort.mergeSortMyLinkedList(myLinkedList);
        return true;
    }

    public void printCollection() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.element);
            System.out.print(' ');
            current = current.nextNode;
        }
        System.out.println();
    }

    public void printReverseCollection() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.element);
            System.out.println(' ');
            current = current.prevNode;
        }
        System.out.println();
    }
}