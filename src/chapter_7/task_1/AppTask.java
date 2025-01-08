package chapter_7.task_1;

public class AppTask {
    public static void main(String[] args) {
        App app1 = new App("Telegram", 7);
        App app2 = new App("WhatsApp", 5);
        App app3 = new App("Instagram", 4);
        Device device = new Device(120);
        device.install(app1);
        device.install(app2);
        device.install(app3);
        device.run("Telegram");
        device.run("WhatsApp");
        device.uninstall("Telegram");

        device.info();



    }
}

class App {
    private String appName;
    private int appSize;

    public App(String appName, int appSize) {
        this.appName = appName;
        this.appSize = appSize;
    }

    public String getAppName() {
        return appName;
    }

    public int getAppSize() {
        return appSize;
    }

    public void setAppSize(int appSize) {
        this.appSize = appSize;
    }
}

class Device {
    private int memory;
    private App[] app;
    private int appCount;
    private boolean[] runningApps;
    private int runCount;

    public Device(int memory) {
        this.memory = memory;
        this.app = new App[memory];
        this.runningApps = new boolean[memory];
        this.appCount = 0;
        this.runCount = 0;
    }

    public boolean install(App apps) {
        int check = checkName(apps.getAppName());
        if (check != -1) {
            app[check].setAppSize(app[check].getAppSize() + apps.getAppSize());
            return true;
        } else if (memory >= apps.getAppSize()) {
            app[appCount] = apps;
            runningApps[appCount] = false;
            appCount++;
            memory -= apps.getAppSize();
            return true;
        } else {
            System.out.println("Not empty memory for install");

        }
        return false;
    }

    private void shiftFiles(int index) {
        for (int i = index; i < appCount - 1; i++) {
            app[i] = app[i + 1];
            runningApps[i] = runningApps[i + 1];
        }
        app[appCount - 1] = null;// remove last element
        runningApps[appCount - 1] = false;//remove last element
        appCount--;
    }

    public boolean uninstall(String name) {
        for (int i = 0; i < appCount; i++) {
            if (app[i] != null && app[i].getAppName().equals(name)) {
                memory += app[i].getAppSize();
                if (runningApps[i]) {
                    runCount--;
                }
                shiftFiles(i);
                System.out.println("App " + name + "Uninstalled successfully");
                return true;
            }
        }
        System.out.println("App not found");
        return false;
    }

    public void run(String name) {
        for (int i = 0; i < appCount; i++) {
            if (app[i].getAppName().equals(name)) {
                if (!runningApps[i]) {
                    runningApps[i] = true;
                    runCount++;
                }
                System.out.println("-------");
                System.out.println("Running app....");
                System.out.println("name = " + app[i].getAppName());
                System.out.println("size = " + app[i].getAppSize());
                return;
            }
        }
        System.out.println("App not found");
    }

    public void info() {
        if (appCount == 0) {
            System.out.println("No apps are running");
            return;
        }
        System.out.println("Running apps");
        for (int i = 0; i < appCount; i++) {
            if (runningApps[i]) {
                System.out.println("-------");
                System.out.println("Name = " + app[i].getAppName());
                System.out.println("Size = " + app[i].getAppSize());
            }
        }
        System.out.println("running apps count  = " + runCount);
    }


    public int checkName(String name) {
        for (int i = 0; i < appCount; i++) {
            if (app[i].getAppName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}