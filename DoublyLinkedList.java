package org.example;

public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getPrev() {
            return this.prev;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E getFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.header.getNext().getElement();
    }

    public E getLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.trailer.getPrev().getElement();
    }

    private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
        Node<E> newNode = new Node<>(element, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void addFirst(E element) {
        this.addBetween(element, header, header.getNext());
    }

    public void addLast(E element) {
        this.addBetween(element, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.remove(header.getNext());
    }

    public E removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.remove(trailer.getPrev());
    }
}
