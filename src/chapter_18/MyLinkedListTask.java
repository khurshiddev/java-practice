package chapter_18;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
    /*add, addAll,addFirst,addLast,clear,
    get, getFirst, getLast, indexOf, remove,
    removeAll,removeFirst ,removeLast*/


public class MyLinkedListTask {
    public static void main(String[] args) {

        MyLinkedList my = new MyLinkedList();
        my.add(10);
        my.add(50);
        my.add(100);
        my.add(80);
        my.showList();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(14);
        list.add(22);
        my.addAll(list);
        System.out.println();
        my.showList();
        System.out.println("-----------");
        my.addFirst(3);
        my.showList();
        System.out.println("----------");
        my.addLast(8);
        my.showList();
        System.out.println("-----------");
        System.out.println(my.get(1));
        System.out.println("------------------");
        System.out.println(my.getFirst());
        System.out.println("----------------");
        System.out.println(my.getLast());
        System.out.println("-----------------------------");
        System.out.println(my.indexOf(3));
        System.out.println("------------------");
        System.out.println(my.removeFirst());
        System.out.println("------------");
        System.out.println(my.removeLast());
        my.removeAll(list);

    }
}

class MyLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void add(int data) {
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

    void showList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    void addAll(Collection<Integer> collection) {
        for (int data : collection) {
            add(data);
        }
    }

    void addFirst(int data) {
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

    void addLast(int data) {
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

    void clear() {
        head = null;
        tail = null;
    }

    int get(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("bunday index yo'q ");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        return current.data;
    }

    int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    int getFirst() {
        if (head == null) {
            System.out.println("LinkedList bo'sh");
        }
        return head.data;
    }

    int getLast() {
        if (tail == null) {
            System.out.println("LinkedList bo'sh");
        }
        return tail.data;
    }

    int indexOf(int data) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == data) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    int remove(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("bundan index yo'q");
        }
        int removeIndex;
        if (index == 0){
            removeIndex = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
        }else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removeIndex = current.next.data;
            current.next = current.next.next;

            if(current.next == null){
                tail = current;
            }
        }
        return removeIndex;
    }

    void removeAll(Collection<Integer> collection) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;

        while (current.next != null) {
            if (collection.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        head = dummy.next;
    }

    int removeFirst() {
        if (head == null) {
            System.out.println("LinkedList bom bo'sh");
        }
        int removeFirst = head.data;
        head = head.next;
        return removeFirst;
    }

    int removeLast() {
        if (head == null) {
            System.out.println("LinkedList bom bo'sh");
        }
        int removeLast = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        return removeLast;
    }
}
