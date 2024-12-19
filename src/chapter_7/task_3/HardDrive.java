package chapter_7.task_3;

public  class HardDrive {
    int hardSize;
    int currentSize;
    int currentIndex;

    HardDrive(int hardSize) {
        this.hardSize = hardSize;
        this.currentSize = 0;


    }

    void write(File file) {
        if (isFull()) {
            System.out.println("hard is full");
        } else if (currentSize + file.fileSize > hardSize) {
            System.out.println("not mepty space");
        } else {
            currentSize += file.fileSize;
            System.out.println("file writed");
        }
    }

    void remove(File file) {
        if (currentSize >= file.fileSize) {
            currentSize -= file.fileSize;
            System.out.println("file removed");
        } else {
            System.out.println("no file");
        }
    }

    void clear() {
        currentSize = 0;
        System.out.println("Hard is cleared");
    }

    boolean isFull() {
        return currentSize == hardSize;
    }

    boolean isEmpty() {
        return currentSize == 0;
    }

    void getUsedSpace() {
        System.out.println(currentSize);
    }

    int getFreeSpace() {
        int space = hardSize - currentSize;
        System.out.println("Free space " + space);
        return space;
    }

}
