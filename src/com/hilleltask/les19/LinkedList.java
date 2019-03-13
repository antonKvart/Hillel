package com.hilleltask.les19;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {

    private static final class LinkedListNode<E> {
        private E element;
        private LinkedListNode<E> next;

        LinkedListNode(E element) {
            this.element = element;
        }
    }

    private class LinkedListIterator implements Iterator<E> {

        private LinkedListNode<E> nextNodeToReturn = head;

        @Override
        public boolean hasNext() {
            return nextNodeToReturn != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator exceeded.");
            }

            E ret = nextNodeToReturn.element;
            nextNodeToReturn = nextNodeToReturn.next;
            return ret;
        }

    }

    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;

    public void add(E element) {
        LinkedListNode<E> newnode = new LinkedListNode<>(element);

        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
}

