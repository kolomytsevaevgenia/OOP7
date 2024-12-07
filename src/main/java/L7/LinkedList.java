package L7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<Node<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        node.getValue(value);
        node.setNext(null);

        if (head == null) { // Если список пустой
            node.setPrevious(null);
            head = node;
            tail = node;
        } else { // Если список не пустой
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
    }

    public Node<T> delete() {
        if (tail == null) {
            return null; // Если список пустой
        }

        Node<T> deletedNode = tail;
        if (tail.getPrevious() != null) {
            tail = tail.getPrevious();
            tail.setNext(null);
        } else { // Если удаляется последний элемент
            head = null;
            tail = null;
        }
        size--;
        return deletedNode;
    }

    public Node<T> delete(T value) {
        if (head == null) {
            return null; // Если список пустой
        }

        Node<T> cur = head;

        while (cur != null) {
            if (cur.getValue().equals(value)) {
                if (cur.getPrevious() != null) {
                    cur.getPrevious().setNext(cur.getNext());
                } else { // Удаляем голову
                    head = cur.getNext();
                }

                if (cur.getNext() != null) {
                    cur.getNext().setPrevious(cur.getPrevious());
                } else { // Удаляем хвост
                    tail = cur.getPrevious();
                }

                size--;
                return cur;
            }
            cur = cur.getNext();
        }

        throw new NoSuchElementException("Элемент не найден");
    }

    public Node<T> findByValue(T value) {
        for (Node<T> elem : this) {
            if (elem.getValue().equals(value)) {
                return elem;
            }
        }
        throw new NoSuchElementException("Элемент не найден");
    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>>() {
            private Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Node<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Нет следующего элемента");
                }
                Node<T> temp = curr;
                curr = curr.getNext();
                return temp;
            }
        };
    }
}


