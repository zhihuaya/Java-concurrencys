package com.thirdstage.juc.collections;

public class LinkedList<E> {

    private Node<E> first;

    private final Node<E> NULL = (Node<E>) null;

    private int size;

    private final static String PLAIN_NULL = "null";

    public LinkedList() {
        this.first = NULL;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static <E> LinkedList<E> of(E... elements) {
        final LinkedList list = new LinkedList();
        if (elements.length > 0) {
            for (E element : elements) {
                list.addFirst(element);
            }
        }
        return list;
    }

    public void addFirst(E e) {
        final Node<E> newNode = new Node<>(e);
        newNode.next = first;
        this.size++;
        first = newNode;
    }

    public boolean contains(E e) {
        Node<E> current = first;
        while (current != null) {
            if (current.value == e) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E removeFirst() {
        if (this.isEmpty()) throw new NoElementException("The LinkeList is empty.");
        Node<E> node = first;
        first.next = node.next;
        size--;
        return node.value;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }else {
            StringBuilder builder = new StringBuilder("[");
            Node<E> current = first;
            while (current.next!=null){
                builder.append(current.value).append(",");
                current = current.next;
            }
            return builder.append(current.value).append("]").toString();
        }
    }
    static class NoElementException extends RuntimeException {

        public NoElementException(String message) {
            super(message);
        }

    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }


    }

    public static void main(String[] args) {
        LinkedList<String> list = LinkedList.of("hello", "world", "java", "scala");
       // list.addFirst("test");
        System.out.println(list.size);
        System.out.println(list.contains("e"));
        System.out.println(list);
    }
}
