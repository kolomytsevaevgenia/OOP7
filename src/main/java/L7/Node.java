package L7;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
public class Node<T> {
    private Node<T> previousNode;
    private Node<T> nextNode;
    private T nodeValue;

    public Node(T value) {
        this.nodeValue = value;
    }

    public Node<T> getPrevious() {
        return previousNode;
    }

    public void setPrevious(Node<T> previous) {
        this.previousNode = previous;
    }

    public Node<T> getNext() {
        return nextNode;
    }

    public void setNext(Node<T> next) {
        this.nextNode = next;
    }

    public T getValue() {
        return nodeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Node<?> otherNode = (Node<?>) obj;
        return Objects.equals(nodeValue, otherNode.nodeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeValue);
    }

    public void getValue(T value) {
    }
}

