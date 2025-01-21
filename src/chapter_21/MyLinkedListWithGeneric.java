package chapter_21;

import org.w3c.dom.Node;

import java.util.Collection;

public class MyLinkedListWithGeneric {
    public static void main(String[] args) {

        MylinkedList<Integer> list = new MylinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(40);

        System.out.println("jami listimiz = ");
        list.showList();
        System.out.println("size =  " + list.size());
        System.out.println("index =  " + list.get(2));
        System.out.println("indexOf =  " + list.indexOf(30));
        System.out.println("remove index =  " + list.remove(1));
        System.out.println("after remove = ");
        list.showList();
        System.out.println("get first element =  " + list.getFirst());
        System.out.println("get last element =  " + list.getLast());
        list.clear();
        System.out.println("-----------------");
        System.out.println("After clear");
        list.showList();
    }
}


class MylinkedList<T> {
    private Node head;
    private Node tail;


    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }

    public void showList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + ", ");
            current = current.next;
        }
    }

    public void addAll(T[] collection) {
        for (T data : collection) {
            add(data);
        }
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("bunday element yo'q");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        return current.data;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public T getFirst() {
        if (head == null) {
            System.out.println("Linked list bo'sh");
        }
        return head.data;
    }

    public T getLast() {
        if (tail == null) {
            System.out.println("Linked list oxirgisi bo'sh");
        }
        return tail.data;
    }

    public int indexOf(T data) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("bunday index yo'q");
        }
        T removeIndex = null;
        if (index == 0) {
            removeIndex = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
                removeIndex = current.next.data;
                current.next = current.next.next;

                if (current.next == null) {
                    tail = current;
                }
            }
        }
        return removeIndex;
    }

}