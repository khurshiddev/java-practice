//package chapter_7.task_1;
//
//class Device extends App {
//    private int memorySize;
//    private App[] instalApps;
//    private int countApp;
//    private boolean runApp;
//
//    Device(int memorySize) {
//        super("", 0);
//        this.instalApps = new App[10];
//        this.memorySize = 0;
//        this.countApp = 0;
//        this.runApp = false;
//
//    }
//
//    boolean install(App app) {
//        if (instalApps ) {
//            instalApps[countApp++] = app;
//            return true;
//        }
//        return false;
//
//    }
//
//    void showApps() {
//        if (countApp == 0) {
//            System.out.println("installed apps no");
//        } else {
//
//            for (int i = 0; i < countApp; i++) {
//                System.out.println(instalApps[i]);
//            }
//        }
//    }
//
//
//}
