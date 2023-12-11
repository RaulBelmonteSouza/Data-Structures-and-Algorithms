package datastructures.linkedlist;

public class LinkedList<T> {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.isEmpty());

        linkedList.addValue(2);
        linkedList.addValue(3);
        linkedList.addValue(5);
        linkedList.addValue(10);
        linkedList.addValue(25);
        linkedList.appendValue(26);
        linkedList.appendValue(27);


        System.out.println(linkedList.size());
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList);
        Node searchResult = linkedList.search(10);
        System.out.println("Searching for the following value: " + 10);
        if (searchResult != null) {
            System.out.println("Value founded: " + searchResult.toString());
        } else {
            System.out.println("Value not found!");
        }
    }

    Node<T> head;
    Node<T> tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node current = head;

        while(current != null) {
            count++;
            current = current.nextNode;
        }

        return count;
    }

    public void addValue(T value) {
        Node node = new Node(value);
        node.nextNode = head;
        head = node;
        if (tail == null) tail = node;

    }

    public void appendValue(T value) {
        Node node = new Node(value);
        if (head == null) head = node;
        if (tail == null) {
            tail = node;
        } else {
            tail.nextNode = node;
            tail = node;
        }
    }

    public Node search(T value) {
        Node current = head;
        while(current != null) {
            if(current.value == value) return current;
            current = current.nextNode;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("HEAD -> " + head.value + " -> ");
        Node current = head.nextNode;
        while(current != null) {
            value.append(current.value).append(" -> ");
            current = current.nextNode;
        }
        return value.toString();
    }

}

class Node<T> {
    public T value;
    public Node nextNode;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value = " + value +
                ", nextNode value = " + nextNode.value +
                '}';
    }
}
