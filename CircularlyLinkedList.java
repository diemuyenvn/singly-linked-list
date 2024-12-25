package org.example;

public class CircularlyLinkedList<E> {
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

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
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
        return this.tail.getNext().getElement();
    }

    public E getLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.tail.getElement();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(E element) {
        if (this.isEmpty()) {
            tail = new Node<>(element, null);
            tail.setNext(tail);
        } else {
            Node<E> newNode = new Node<>(element, this.tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(E element) {
        this.addFirst(element);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Node<E> head = this.tail.getNext();
        if (head == this.tail) {
            this.tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
}
