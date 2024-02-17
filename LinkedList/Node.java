class Node<T> {
    private T data;
    private Node<T> next;
    public Node (T data , Node<T> next ) {
        this.data = data;
        this.next = next;
    }
    public Node (T data) {
        this(data, null);
    }
    public T getData() {
        return this.data;
    }
    public void setData( T newdata ) {
        this.data = newdata;
    }
    public Node<T> getNext() {
        return this.next;
    }
    public void setNext( Node<T> newnext) {
        this.next = newnext;
    }
}
