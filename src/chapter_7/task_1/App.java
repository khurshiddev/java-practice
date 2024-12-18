package chapter_7.task_1;

class App {
    String appName;
    int appSize;

    App(String name, int appSize) {
        this.appName = name;
        this.appSize = appSize;
    }

    @Override
    public String toString() {
        return "AppName" + appName + " size = " + appSize;
    }
}
