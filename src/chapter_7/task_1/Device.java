package chapter_7.task_1;

class Device {
    private App[] apps;
    private int appCount;
    private int emptySpace;

    Device(int size) {
        apps = new App[size];
        emptySpace = size;
    }

    boolean install(App app) {
        if (emptySpace >= app.getSize() && indexOf(app.getName()) == -1) {
            apps[appCount++] = app;
            emptySpace -= app.getSize();
            return true;
        }
        return false;
    }

    void showApps() {
        for (int i = 0; i < appCount; i++) {
            App app = apps[i];
            showApp(app);
        }
        System.out.println();
    }

    boolean uninstall(String name) {
        int index = indexOf(name);
        if (index == -1) return false;

        App app = apps[index];
        emptySpace += app.getSize();

        App lastItem = apps[appCount - 1];
        apps[index] = lastItem;
        apps[appCount - 1] = null;

        appCount--;
        System.out.println("uninstall");
        showApp(app);
        return true;
    }

    void run(String name) {
        int index = indexOf(name);
        if(index == -1){
            System.out.println(" not found");
            return;
        }
        App app = apps[index];
        app.isRunning = true;
        System.out.println("Running");
        showApp(app);
    }

    private void showApp(App app) {
        System.out.println("Name: " + app.getName());
        System.out.println("Size: " + app.getSize());

    }

    private int indexOf(String name) {
        for (int i = 0; i < appCount; i++) {
            App app = apps[i];
            if (app.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    void info() {
        System.out.println("Running apps:");
        for (int i = 0; i < appCount; i++) {
            App app = apps[i];
            if(app.isRunning){
                showApp(app);
            }
        }
    }
}

