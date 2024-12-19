package chapter_7.task_1;

public class Main {
        public static void main(String[] args) {
            App app = new App("Telegram", 7);
            Device device = new Device(50);
            device.install(app);
            device.install(new App("Google", 20));
            device.install(new App("Chrome", 25));
            device.showApps();
            device.run("Telegram");
            device.info();
            device.uninstall("Telegram");
            device.showApps();
        }
    }

