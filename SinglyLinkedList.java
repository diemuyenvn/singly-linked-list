package org.example;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E getFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.getElement();
    }

    public E getLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.tail.getElement();
    }

    public void addFirst(E element) {
        this.head = new Node<>(element, this.head);
        if (this.isEmpty()) {
            this.tail = this.head;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        E element = this.head.getElement();
        this.head = this.head.getNext();
        size--;
        if (this.isEmpty()) {
            this.tail = null;
        }
        return element;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> currentNode = this.head;
        while (currentNode != null) {
            sb.append(currentNode.getElement());
            sb.append(", ");
            currentNode = currentNode.getNext();
        }
        int length = sb.length();
        sb.delete(length - 2, length);
        sb.append("]");
        return sb.toString();
    }
}
