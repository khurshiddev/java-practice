package chapter_20;

import java.util.*;

public class AppManagerTask {
    public static void main(String[] args) {

    }
}

class App {
    private String name;
    private String developer;
    private String version;

    public App(String name, String developer, String version) {
        this.name = name;
        this.developer = developer;
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        App app = (App) o;
        return Objects.equals(name, app.name) && Objects.equals(developer, app.developer) && Objects.equals(version, app.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, developer, version);
    }
}

class AppManager {
    Set<App> apps;
    Map<App, String> appStatus;
    Map<App, Integer> appUsageStatus;

    public AppManager() {
        apps = new HashSet<>();
        appStatus = new HashMap<>();
        appUsageStatus = new HashMap<>();
    }

    boolean addApp(App app) {
        if (apps.contains(app)) {
            return false;
        }
        apps.add(app);
        appStatus.put(app, "faol");
        appUsageStatus.put(app, 0);
        return true;
    }

    boolean removeApp(App app) {
        if (!apps.contains(app)) {
            return false;
        }
        apps.remove(app);
        appStatus.remove(app);
        appUsageStatus.remove(app);
        return true;
    }

    boolean updateAppStatus(App app, String status) {
        if (!apps.contains(app)) {
            return false;
        }
        if (!status.equals("faol") && !status.equals("mashg'ul") && !status.equals("to‘xtatilgan")) {
            return false;
        }
        appStatus.put(app, status);
        return true;
    }

    void incrementAppUsage(App app) {
        if (apps.contains(app)) {
            int count = appUsageStatus.getOrDefault(app, 0);
            appUsageStatus.put(app, count + 1);
        }
    }

    App getMostUsedApp(){
        App used = null;
        int maxUsed = 0;

        for (Map.Entry<App,Integer> entry : appUsageStatus.entrySet()){
            if(entry.getValue() > maxUsed){
                used = entry.getKey();
                maxUsed = entry.getValue();
            }
        }
        return used;
    }

    Set<App> getAppsByStatus(String status){
        Set<App> res = new HashSet<>();
        for(Map.Entry<App, String> entry : appStatus.entrySet()){
            if(entry.getValue().equals(status)){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}