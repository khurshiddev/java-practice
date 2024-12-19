package chapter_7.task_3;

public class Main {
    public static void main(String[] args) {
        HardDrive hd = new HardDrive(250);
        File file = new File("Gita-10", 20);
        hd.write(file);
        boolean isFull = hd.isFull();
        boolean isEmpty = hd.isEmpty();
        int t = hd.getFreeSpace();
    }
}
