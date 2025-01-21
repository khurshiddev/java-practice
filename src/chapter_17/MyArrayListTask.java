package chapter_17;

import java.util.Arrays;
import java.util.function.Consumer;

public class MyArrayListTask {
    public static void main(String[] args) {
        MyArrayList my = new MyArrayList();
        my.add("A");
        my.add("B");
        my.add("C");
        my.add("D");
        System.out.println(my.get(1));
        System.out.println(my.contains("C"));
        System.out.println("remove = "+my.remove("B"));
        System.out.println("set = "+my.set(2, "salom"));
        System.out.println(my.isEmpty());
        my.forEach(s -> {
            System.out.println(my);
        });
        my.clear();
    }
}

class MyArrayList {
    private String[] values;
    private int size;

    public MyArrayList() {
        values = new String[10];
    }

    public MyArrayList(int initCapacity) {
        values = new String[initCapacity];
    }

    public void add(String value) {
        checkResize();
        values[size++] = value;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "values=" + Arrays.toString(values) +
                ", size=" + size +
                '}';
    }

    private void checkResize() {
        if (values.length == 0) {
            String[] temp = values;
            values = new String[size + size / 2];

            for (int i = 0; i < temp.length; i++) {
                values[i] = temp[i];

            }
        }
    }

    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) return true;
        }
        return false;
    }

    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) return i;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public String get(int index) {
        return values[index];
    }

    public int lastIndex(String value) {
        for (int i = size; i >= 0; i--) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    private void removeAt(int index) {
        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        values[size - 1] = null;// oxirini o'chirish
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String set(int index, String value) {
        if (index > 0 || index >= size) {
            System.out.println("bunday element yo'q");
        }
        String oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    public void forEach(Consumer<String> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(values[size]);
        }
    }

}