package com.trubin.datastructures.list;

import java.util.NoSuchElementException;

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;

    private void raiseNoSuchElementException() {
        throw new NoSuchElementException();
    }

    private void checkIndex(int index) {
        if (index < 0 || size == 0 || index > size) {
            raiseNoSuchElementException();
        }
    }

    private Node getNode(int index) {
        checkIndex(index);

        Node current;
        int i;

        if (index < (size - 1) / 2) {
            current = head;
            i = 0;

            while (current.next != null) {
                if (i == index) {
                    return current;
                }

                current = current.next;
                i++;
            }
        } else {
            current = tail;
            i = size - 1;

            while (current.prev != null) {
                if (i == index) {
                    return current;
                }

                current = current.prev;
                i--;
            }
        }

        raiseNoSuchElementException();

        return null;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);

        tail = newNode;

        if (size == 0) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            newNode.prev = current;
        }

        size++;
    }

    @Override
    public void add(Object value, int index) {
        checkIndex(index);

        Node newNode = new Node(value);
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;

        if (index == 0) {
            head = newNode;
        } else if (index == size - 1 && size > 1) {
            tail = newNode;
        }

        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        prevNode.next = newNode;

        size++;
    }

    public Object remove(int index) {
        if (size == 0) {
            return null;
        }

        Node toRemoveNode = getNode(index);
        Node nextNode = toRemoveNode.next;
        Node prevNode = toRemoveNode.prev;

        if (prevNode != null) {
            if (nextNode != null) {
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            } else {
                prevNode.next = null;
                tail = prevNode;
            }
        } else {
            if (nextNode != null) {
                nextNode.prev = null;
                head = nextNode;
            }
        }

        size--;

        return null;
    }

    @Override
    public Object get(int index) {
        return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        Node toSetNode = getNode(index);
        toSetNode.value = value;

        return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public boolean contains(Object value) {
        Node current = head;

        if (current.value.equals(value)) {
            return true;
        }

        while (current.next != null) {
            current = current.next;

            if (current.value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node current = head;
        int i = 0;

        if (current.value.equals(value)) {
            return i;
        }

        while (current.next != null) {
            current = current.next;
            i++;

            if (current.value.equals(value)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = head;
        int i = 0;
        int j = -1;

        if (current.value.equals(value)) {
            return i;
        }

        while (current.next != null) {
            current = current.next;
            i++;

            if (current.value.equals(value)) {
                j = i;
            }
        }

        return j;
    }
}
