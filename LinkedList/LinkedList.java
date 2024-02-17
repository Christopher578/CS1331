import java.util.NoSuchElementException;
class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }
    public Node<T> getHead() {
    return this.head;
    }
    public Node<T> getTail() {
    return this.tail;
    }
    @Override
    public void addAtIndex(T data, int index) {
        
        
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Your index is out of the list bounds");
        else if (data == null)
            throw new IllegalArgumentException("You cannot add null data to the list");
        Node<T> node = new Node <> (data);
        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else if (index == 0) {
         node.setNext(head);
         head = node;
        }    
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++)
            current = current.getNext();
            node.setNext(current.getNext());
            current.setNext(node);
            if (index == size)
                tail = node;
        }
        size++;

    }
    @Override
    public T getAtIndex(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Your index is out of the list bounds");
        else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) 
                current = current.getNext();
        return  current.getData();
            }
    }
    @Override
    public T removeAtIndex(int index) {
        T removedData;
        
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Your index is out of bounds");
        else if (isEmpty())
            removedData = null;
        
        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            if (size == 1)
                tail = null;
        }
        else {   
            Node<T> current = head;
            for (int i = 0; i < index -1 ; i++)
                current = current.getNext();
                removedData = current.getNext().getData();
                current.setNext(current.getNext().getNext());
            if (index == size - 1)
                tail = current;
            }
    size--;
    return removedData;
    }
    @Override
    public T remove(T data) {
    T removedData = null;
    if (data == null)
        throw new IllegalArgumentException("You cannot remove null data from the list");
    else if (isEmpty())
        throw new NoSuchElementException("The data is not present in the list.");

    if (head.getData().equals(data)) {
        removedData = head.getData();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
    } else {
        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                removedData = current.getNext().getData();
                current.setNext(current.getNext().getNext());
                size--;

                if (current.getNext() == null)
                    tail = current;

                break;
            }
            current = current.getNext();
        }
    }

    return removedData;
}
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public boolean isEmpty() {
    return (head == null); //the list is empty if head is null
    }
    @Override
    public int size() {
    return size;
    } 
}
