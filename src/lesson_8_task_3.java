public class lesson_8_task_3 {
    public static class Main {
        public static void main(String[] args) {

            HardDrive hd = new HardDrive(250);
            File file = new File("Gita-10", 20);
            hd.write(file);
            boolean isFull = hd.isFull();
            boolean isEmpty = hd.isEmpty();
            int t = hd.getFreeSpace();
        }
    }

    public static class File {
        String fileName;
        double fileSize;

        File(String fileName, double fileSize){
            this.fileName = fileName;
            this.fileSize = fileSize;

        }
    }

    public static class HardDrive {
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
}

