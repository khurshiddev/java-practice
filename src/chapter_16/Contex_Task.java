package chapter_16;

import java.util.Random;

public class Contex_Task {
    public static void main(String[] args) {
        LogListener logListener = message -> System.out.println("Show: " + message); // LogListener shunchaki lambda orqali yozildi
        RegisterController controller = new RegisterController(logListener);

        UserData user1 = new UserData("Alice", "+9981234567890", 20);
        UserData user2 = new UserData("Bob", "+998987654321", 18);

        controller.register(user1);
        controller.register(user2);

        // Example: Check SMS code
        controller.checkSmsCode(user1.getSmsCode(), user1.getTel());

        // Resend SMS code
        controller.repeatSendSmsCode(user1);
        user1.show(user2);


    }
}

class UserData {
    private String name;
    private String tel;
    private int age;
    private int smsCode;
    private boolean isRegistered;

    public UserData(String name, String tel, int age) {
        this.name = name;
        this.tel = tel;
        this.age = age;
        this.isRegistered = false;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public int getAge() {
        return age;
    }

    public int getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(int smsCode) {
        this.smsCode = smsCode;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "age=" + age +
                ", tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void show(UserData user) {
        System.out.println("name = " + name);
        System.out.println("Age = " + age);
        System.out.println("Phone number = " + tel);

    }
}

@FunctionalInterface
interface LogListener {
    void showMessage(String message);
}

@FunctionalInterface
interface UserInfoInterface {
    void show(UserData user);
}

class RegisterController {
    private UserData[] users;
    private LogListener logListener;
    private UserInfoInterface userListener;
    private int userCount;
    private int maxUsers = 100;

    public RegisterController(LogListener logListener) {
        this.logListener = logListener;
        this.users = new UserData[maxUsers];
    }

    public void register(UserData user) {
        if (userCount >= maxUsers) {
            logListener.showMessage("bo'sh joy yo'q");
            return;
        }
        for (int i = 0; i < userCount; i++) {
            if (users[i].getTel().equals(user.getTel())) {
                logListener.showMessage("bu odam avval qo'shilgan");
                return;
            }
        }
        if (check(user)) {
            users[userCount++] = user;
        }
    }

    private boolean check(UserData user) {
        String name = user.getName();
        String tel = user.getTel();
        int age = user.getAge();
        if (name == null || !name.matches("[a-zA-z]{3,12}")) {
            logListener.showMessage("ismni to'g'ri kirgizing uzunligini ham");
            return false;
        }
        if (tel == null || !tel.matches("\\+998\\d{10}")) {
            logListener.showMessage("raqamni to'g'ri formatta kirgizing");
            return false;
        }
        if (age < 16 || age > 25) {
            logListener.showMessage("tosh 16 dan 25 oralig'ida bo'lishi kerak");
            return false;
        }
        sendSmsCode(user);
        return true;
    }

    private void sendSmsCode(UserData user) {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        user.setSmsCode(code);
        logListener.showMessage(code + " = shu sms code yuvorildi = " + user.getTel() + " telefon raqamiga ");
    }

    public void checkSmsCode(int code, String phoneNumber) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getTel().equals(phoneNumber)) {
                if (users[i].getSmsCode() == code) {
                    users[i].setRegistered(true);
                    logListener.showMessage("ro'yhatdan o'tdi");
                    return;
                } else {
                    logListener.showMessage(" ro'yhatdan o'tilmadi code to'gri emas ");
                    return;
                }
            }
        }
        logListener.showMessage("bu raqamli ishtirokchi topilmadi");
    }

    public void repeatSendSmsCode(UserData user) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getTel().equals(user.getTel()) && !users[i].isRegistered()) {
                sendSmsCode(users[i]);
                logListener.showMessage("sms ayta yuvorildi = " + users[i].getTel());
                return;
            }
        }
        logListener.showMessage("bu odam oldin ro'yhatdan o'tgan");
    }

    public void showAllUsers(UserInfoInterface userListener) {
        if (userCount == 0) {
            logListener.showMessage("ro'yhat bom bo'sh");
            return;
        }
        for (int i = 0; i < userCount; i++) {
            userListener.show(users[i]);

        }
    }
    public void unregister(UserData user){
        for (int i = 0; i < userCount; i++) {
            if(users[i].getTel().equals(user.getTel())){
                if (users[i].isRegistered()){
                    users[i].setRegistered(false);
                    logListener.showMessage(user.getName() + " shu inson ro'yhatdan o'chirildi");
                    return;
                }else {
                    logListener.showMessage("bu inson ro'yhatdan o'tmagan");
                }
            }
        }
    }
}
