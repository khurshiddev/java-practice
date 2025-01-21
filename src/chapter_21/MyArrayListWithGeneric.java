package chapter_21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class MyArrayListWithGeneric {
    public static void main(String[] args) {

    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(123879);
    list.contains(2);
    list.add(50);
    list.get(1);
    list.remove(3);
    list.set(1,6);
    list.indexOf(5);
    list.lastIndex(9);
    list.isEmpty();
    list.clear();
    }
}


class MyArrayList<T> {
    private T[] values;
    private int size;

    public MyArrayList() {
        values = (T[]) new Object[10];
    }

    public MyArrayList(int initCapacity) {
        values = (T[]) new Object[initCapacity];
    }

    void add(T value) {
        checkResize();
        values[size++] = value;
    }

    int size() {
        return size;
    }

    private void checkResize() {
        T[] temp = values;
        if (values.length == size) {
            values = (T[]) new Object[size + size / 2];
            for (int i = 0; i < temp.length; i++) {
                values[i] = temp[i];

            }
        }
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) return true;

        }
        return false;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) return i;

        }
        return -1;
    }

    public T get(int index) {
        return values[index];
    }

    public int lastIndex(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(T value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private void removeAt(int index) {
        for (int i = index; i < size - 1; i++) {
                values[i] = values[i + 1];
            }
            values[size - 1] = null;
            size--;

    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            values[i] = null;

        }
        size = 0;
    }

    public T set(int index, T value){
        if(index < 0 || index >= size){
            System.out.println("bunday malumot yo'q");
        }
        T oldValue = values[index];
        values[index] = value;
        return oldValue;
    }
}