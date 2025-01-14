package chapter_16;

import java.util.Random;

public class TelegramTask {
    public static void main(String[] args) {

        Telegram telegram = new Telegram();
        User user1 = new User("Alice", "Smith", 25, "+998901234567");
        User user2 = new User("Bob", "Brown", 22, "+998901234568");
        User user3 = new User("Alice", "Smith", 25, "+998901234567"); // user1 bilan bir xil telefon raqam

        System.out.println("--------------");
        telegram.createAccount(user1);
        telegram.createAccount(user2);
        telegram.createAccount(user3);

        telegram.getUserCount();

        System.out.println("------------");
        telegram.checkSmsCode(user1.getSmsCode(), user1.getPhoneNumber());
        telegram.checkSmsCode(1234, user1.getPhoneNumber());

        System.out.println("----------------");
        telegram.deleteAccount(user1.getPhoneNumber());
        telegram.deleteAccount(user2.getPhoneNumber());
        telegram.getUserCount();
    }
}

class Telegram {
    private User[] users;
    private int count;

    public Telegram() {
        this.users = new User[20];
        this.count = 0;
    }


    public boolean createAccount(User user) {
        for (int i = 0; i < count; i++) {
            if (users[i].getPhoneNumber().equals(user.getPhoneNumber())) {
                System.out.println("odin ro'yhatdan o'tgan");
                return false;
            }
        }
        sendSmsCode(user);
        users[count++] = user;
        return true;
    }


    private void sendSmsCode(User user) {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        user.setSmsCode(code);
        System.out.println(code + " = shu code yuvorildi " + user.getPhoneNumber());
    }


    void checkSmsCode(int code, String phoneNumber) {
        for (int i = 0; i < count; i++) {
            if (users[i].getPhoneNumber().equals(phoneNumber)) {
                if (users[i].getSmsCode() == code) {
                    users[i].setRegistered(true);
                    System.out.println("ro'yhatdan o'tkazildi");
                    return;
                } else {
                    System.out.println("code hato");
                    return;
                }
            }

        }
        System.out.println("bu raqam ro'yhatda topilmadi");

    }

    void getUserCount() {
        System.out.println("user count = " + count);
    }

    public boolean deleteAccount(String phoneNumber) {
        for (int i = 0; i < count; i++) {
            if (users[i].getPhoneNumber().equals(phoneNumber)) {
                if (users[i].isRegistered()) {
//                    users[i].setRegistered(false);
                    System.out.println(phoneNumber + " = shu raqamli mijoz ochilirdi");
                    for (int j = 0; j < count - 1; j++) {
                        users[j] = users[j + 1];
                    }
                    users[--count] = null;
                    return true;
                } else {
                    System.out.println("bu inson ro'yhatdan o'tmagan");
                    return false;
                }
            }

        }
        return false;
    }
}

class User {
    private String firstName;
    private String lastName;
    private int age;
    private int smsCode;
    private String phoneNumber;
    private boolean registered;

    public User(String firstName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.registered = false;
    }


    public int getAge() {
        return age;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(int smsCode) {
        this.smsCode = smsCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

