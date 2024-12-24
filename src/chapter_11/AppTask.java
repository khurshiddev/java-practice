package chapter_11;

public class AppTask {
        public static class Main {
            public static void main(String[] args) {
                App app = new App("Instagram", 7);
                Device device = new Device(50);
                device.install(app);
                device.install(new App("TikTok", 20));
                device.install(new App("CarrotApp", 25));
                device.showApps();
                device.run("Instagram");
                device.info();
                device.uninstall("Telegram");
                device.showApps();
            }
        }

        static class App{
            private String name;
            private int size;
            boolean isRunning;

            App(String name, int size) {
                this.name = name;
                this.size = size;
            }

            public String getName() {
                return name;
            }
            public int getSize() {
                return size;
            }
        }

        static class Device {
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
    }


